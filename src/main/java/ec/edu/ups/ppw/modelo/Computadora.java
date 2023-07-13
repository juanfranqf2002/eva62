package ec.edu.ups.ppw.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Computadora {

	@Id
	@GeneratedValue
	@Column(name="com_codigo")
	private int codigo;
	
	@Column(name="com_modelo")
	private String modelo;
	
	@Column(name="com_tipo")
	private String tipo;
	
	@Column(name="com_tamanio")
	private String tamanio;
	
	@Column(name="com_precio")
	private double precio;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Computadora [codigo=" + codigo + ", modelo=" + modelo + ", tipo=" + tipo + ", tamanio=" + tamanio
				+ ", precio=" + precio + "]";
	}
	
}
