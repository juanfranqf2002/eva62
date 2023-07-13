package ec.edu.ups.ppw.negocio;

import ec.edu.ups.ppw.datos.ComputadoraDAO;
import ec.edu.ups.ppw.modelo.Computadora;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DatosDemo {
	
	@Inject
	ComputadoraDAO daoComputadora;
	
	@PostConstruct
	public void init() {
		Computadora c=new Computadora();
		
		c.setModelo("Apple");
		c.setTipo("Laptop");
		c.setTamanio("12p");
		c.setPrecio(500);
		//daoProducto.insert(p);
		System.out.print(c.toString());
	}

}
