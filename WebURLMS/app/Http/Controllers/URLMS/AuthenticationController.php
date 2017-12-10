<?php

namespace App\Http\Controllers\URLMS;

use Illuminate\Http\Request;
use Exception;

class AuthenticationController extends URLMSController {
	public function login(Request $request) {
		$this->updateCurrent ( $request );
		$email = $this->cleanString($request->input ( 'email' ));
		$password = $request->input ( 'password' );
		
		$labs = $this->urlms->getLaboratories ();
		
		foreach ( $this->urlms->getDirectors () as $dir ) {
			if ($dir->getEmail () == $email && $dir->getPassword () == $password) {
				$this->currentUser = $dir;
				
				$request->session ()->put ( 'logged-in', true );
				$request->session ()->put ( 'email', $email );
				$request->session ()->put ( 'director', true );
				
				return response ()->json ( [ 
						'status' => true 
				] );
			}
		}
		
		if ($this->urlms->numberOfLaboratories () != 0) {
			foreach ( $labs as $lab ) {
				foreach ( $lab->getStaffs () as $staff ) {
					if ($staff->getEmail () == $email && $staff->getPassword () == $password) {
						$this->currentUser = $staff;
						
						date_default_timezone_set ( 'America/New_York' );
						$staff->setLastLogin ( date ( 'm/d/Y - h:ia' ) );
						PersistenceController::saveModel ( $this->urlms );
						
						$request->session ()->put ( 'logged-in', true );
						$request->session ()->put ( 'email', $email );
						$request->session ()->put ( 'director', false );
						
						return response ()->json ( [ 
								'status' => true 
						] );
					}
				}
			}
		}
		
		return response ()->json ( [ 
				'status' => false 
		] );
	}
	public function register(Request $request) {
		$this->updateCurrent ( $request );
		$name = $this->cleanString($request->input ( 'name' ));
		$email = $this->cleanString($request->input ( 'email' ));
		$password = $request->input ( 'password' );
		
		if ($name == null || $name == '' || $email == null || $email == '' || $password == null || $password == '') {
			return response ()->json ( [ 
					'status' => false,
					'message' => 'Empty string detected' 
			] );
		}
		
		foreach ( $this->urlms->getDirectors () as $dir ) {
			if ($dir->getEmail () == $email) {
				return response ()->json ( [ 
						'status' => false,
						'message' => 'A director is already using this email' 
				] );
			}
		}
		
		try {
			$this->currentUser = $this->urlms->addDirectorVia ( $email, $password, $name );
			PersistenceController::saveModel ( $this->urlms );
		} catch ( Exception $e ) {
			return response ()->json ( [ 
					'status' => false,
					'message' => $e->getMessage () 
			] );
		}
		
		$request->session ()->put ( 'logged-in', true );
		$request->session ()->put ( 'email', $email );
		$request->session ()->put ( 'director', true );
		
		return response ()->json ( [ 
				'status' => true,
				'name' => $name 
		] );
	}
	public function logout(Request $request) {
		$this->updateCurrent ( $request );
		PersistenceController::saveModel($this->urlms);
        $request->session()->forget(['logged-in', 'email', 'labName', 'director']);
        
        return response()->json(['status' => true]);
    }
}