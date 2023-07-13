package ec.edu.ups.ppw.negocio;

import java.util.List;

import ec.edu.ups.ppw.datos.*;
import ec.edu.ups.ppw.modelo.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionComputadora {

	@Inject
	public ComputadoraDAO daoComputadora;

	public void guardarComputadora(Computadora computadora) throws Exception {

		if (daoComputadora.read(computadora.getCodigo()) == null) {
			try {
				daoComputadora.insert(computadora);
			} catch (Exception e) {
				throw new Exception("Error al ingresar:" + e.getMessage());
			}
		} else {
			try {
				daoComputadora.update(computadora);
			} catch (Exception e) {
				throw new Exception("Error al Actualizar:" + e.getMessage());

			}
		}
	}

	public boolean isCodigoValido(int idComputadora) {
		return idComputadora == 0 || idComputadora != 0;
	}

	public List<Computadora> listaComputadora() {
		return daoComputadora.getAll();
	}
	
	public void eliminarComputadora(Computadora computadora) throws Exception {
	    if (daoComputadora.read(computadora.getCodigo()) != null) {
	        try {
	            daoComputadora.delete(computadora.getCodigo());;
	        } catch (Exception e) {
	            throw new Exception("Error al eliminar: " + e.getMessage());
	        }
	    } else {
	        throw new Exception("La computadora no existe en la base de datos");
	    }
	}


	public void actualizarComputadora(Computadora computadora) throws Exception {
	    if (daoComputadora.read(computadora.getCodigo()) != null) {
	        try {
	            daoComputadora.update(computadora);
	        } catch (Exception e) {
	            throw new Exception("Error al actualizar: " + e.getMessage());
	        }
	    } else {
	        throw new Exception("La computadora no existe en la base de datos");
	    }
	}
	
	public Computadora readComputadora(int codigo) throws Exception {
	    try {
	        Computadora computadora = daoComputadora.read(codigo);
	        if (computadora != null) {
	            return computadora;
	        } else {
	            throw new Exception("La computadora no existe en la base de datos");
	        }
	    } catch (Exception e) {
	        throw new Exception("Error al leer la computadora: " + e.getMessage());
	    }
	}


}
