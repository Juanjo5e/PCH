package co.edu.uco.pch.controller;

import java.util.List;

import co.edu.uco.pch.controller.response.CiudadResponse;
import co.edu.uco.pch.crosscutting.Exception.PCHException;
import co.edu.uco.pch.dto.CiudadDTO;

@RestController
@RequestMapping("/api/v1/ciudades")

public final class CiudadController {
	
	
	@GetMapping ("/dummy")
	public CiudadDTO dummy() {
		return CiudadDTO.buil();
	}
	public ResponEntity<CiudadResponse> consultar(){
		
		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();
		try {
			
		}catch (final PCHException exception) {
			httpStatusCode =HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensaje().add(exception.getMensajeUsuario());
			exception.printStackTrace();
			
		}catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario = "";
			
			excepcion.printStackTrace();
			
		}
		return new ResponseEntity
		
	}

}