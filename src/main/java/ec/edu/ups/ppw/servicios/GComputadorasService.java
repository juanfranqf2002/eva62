package ec.edu.ups.ppw.servicios;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.ppw.modelo.Computadora;
import ec.edu.ups.ppw.negocio.GestionComputadora;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("computadoras")
public class GComputadorasService {
	
	
	@Inject 
	private GestionComputadora gestionComputadora;
	
	
	@GET
	@Path("misdatos")
	@Produces("application/json")
	public Computadora misDatos() {
		Computadora c = new Computadora();
		c.setModelo("Asus");
		c.setTipo("Laptop");
		c.setTamanio("15p");
		c.setPrecio(200);
		return c;
	}
	
	@GET
	@Path("listaComputadoras")
	@Produces("application/json")
	public List<Computadora> datos() {
	    return gestionComputadora.listaComputadora();
	}
	
	
	@POST
	@Path("agregar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarComputadora(Computadora computadora)
	{
		try {
			gestionComputadora.guardarComputadora(computadora);
			return Response.status(Response.Status.OK).entity(computadora).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			Error error =new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar:"+e.getMessage());
			return Response.status(Response.Status.OK).entity(computadora).build();
		}
	}
	
	
	@POST
	@Path("/eliminar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response eliminarComputadora(Computadora computadora) {
	    try {
	        gestionComputadora.eliminarComputadora(computadora);
	        return Response.status(Response.Status.OK).entity(computadora).build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        Error error = new Error();
	        error.setCodigo(99);
	        error.setMensaje("Error al eliminar: " + e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
	    }
	}

	@POST
	@Path("/actualizar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response actualizarComputadora(Computadora computadora) {
	    try {
	        gestionComputadora.actualizarComputadora(computadora);
	        return Response.status(Response.Status.OK).entity(computadora).build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        Error error = new Error();
	        error.setCodigo(99);
	        error.setMensaje("Error al actualizar: " + e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
	    }
	}


}
