package gestor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.validator.EmailValidator;

import dao.PasajeroDAO;
import dao.PasajeroDAO_Hibernate;
import dominio.Pasajero;
import dominio.Persona;
import dto.BusquedaPasajeroDTO;
import dto.PasajeroDTO;

@SuppressWarnings("deprecation")
public class GestorPasajero {

	PasajeroDAO daoPasajero = new PasajeroDAO_Hibernate();
	Pasajero pasajero = new Pasajero();
	GestorPersona gestorPersona = new GestorPersona();
	DefaultTableModel dtm;

	public void darDeAltaPasajero(PasajeroDTO pasajeroDTO) throws Exception {

		int variable = 0;

		if (gestorPersona.buscarDNI(pasajeroDTO.getNumeroDocumento()))
			variable = JOptionPane.showConfirmDialog(null, "¿Estas seguro que quiere dar de alta el pasajero?",
					"Cuidado", JOptionPane.YES_NO_OPTION);

		if (variable == 0) {

			Persona persona = gestorPersona.darDeAltaPersona(pasajeroDTO);
			pasajero.inicializarPasajero(persona);
			daoPasajero.guardarPasajero(pasajero);
		}

		else
			throw new Exception("No se pude dar de alta el nuevo pasajero");

	}

	public Boolean validarDatos(JTextField textNumeroDocumento, JTextField textTelefono, JTextField textEmail,
			JTextField textPiso) throws Exception {

		Boolean dniValido = true, telefonoValido = true, emailValido = true, pisoValido = true;

		String mensaje = "Datos invalidos, revisar: ";

		if (textNumeroDocumento.getText().toString().length() != 8
				&& textNumeroDocumento.getText().toString().length() != 7) {
			mensaje += "DNI ";
			dniValido = false;
		}

		if (textTelefono.getText().toString().length() != 10) {
			mensaje += "TELEFONO ";
			telefonoValido = false;
		}

		if (!EmailValidator.getInstance().isValid(textEmail.getText().toString())) {
			mensaje += "EMAIL ";
			emailValido = false;
		}

		if (Integer.parseInt(textPiso.getText().toString()) <= 0) {
			mensaje += "PISO ";
			pisoValido = false;
		}

		if (!dniValido || !telefonoValido || !emailValido || !pisoValido) {
			throw new Exception(mensaje);
		} else
			return true;
	}

	public Boolean validarPasajero(BusquedaPasajeroDTO pasajero) {
		return true;
	}

	public void vaciarTabla(JTable table) {

		dtm = (DefaultTableModel) table.getModel();

		for (int i = dtm.getRowCount() - 1; i >= 0; i--)
			dtm.removeRow(i);

	}

	public List<BusquedaPasajeroDTO> recuperarPasajeros(BusquedaPasajeroDTO pasajeroBusqueda) {

		GestorPersona gestorPersona = new GestorPersona();

		List<Persona> listaPersonas = gestorPersona.recuperarPasajeros(pasajeroBusqueda);

		List<BusquedaPasajeroDTO> listaPasajeros = new ArrayList<BusquedaPasajeroDTO>();

		for (Persona p : listaPersonas) {
			BusquedaPasajeroDTO aux = new BusquedaPasajeroDTO();
			aux.setApellido(p.getApellido());
			aux.setNombre(p.getNombre());
			aux.setNumeroDeDocumento(p.getNumeroDocumento().toString());
			aux.setTipoDeDocumento(p.getTipoDocumento());
			listaPasajeros.add(aux);
		}

		return listaPasajeros;

	}

	public void ingresarATablaResultados(List<BusquedaPasajeroDTO> listaCoincidencias, JTable table) {

		ArrayList<Object[]> datos = new ArrayList<>();

		for (int j = 0; j < listaCoincidencias.size(); j++) {
			Object[] filas = new Object[4];
			for (int i = 0; i < 4; i++) {
				filas[i] = listaCoincidencias.get(j).getColumna(i);
			}
			datos.add(filas);
		}
		dtm = (DefaultTableModel) table.getModel();
		for (int i = 0; i < datos.size(); i++) {
			dtm.addRow(datos.get(i));
		}
	}

	public List<List<Object>> validarEmpty(JTextField textApellido, JTextField textNombre,
			JTextField textNumeroDocumento, JTextField textOcupacion, JTextField textTelefono, JTextField textEmail,
			JTextField textNacionalidad, JTextField textCalle, JTextField textNum, JTextField textCuit, JLabel lblCuit,
			JLabel lblApellido, JLabel lblNombre, JLabel lblNumDocumento, JLabel lblOcupacion, JLabel lblTelefono,
			JLabel lblEmail, JLabel lblNacionalidad, JLabel lblCalle, JLabel lblNum, Boolean cuitActivo) {

		List<Object> listaTextVacios = new ArrayList<Object>();
		List<Object> listaTextNoVacios = new ArrayList<Object>();
		List<Object> listaLabelVacios = new ArrayList<Object>();
		List<Object> listaLabelNoVacios = new ArrayList<Object>();

		List<List<Object>> listRetorno = new ArrayList<>();

		if (textApellido.getText().isEmpty()) {
			listaTextVacios.add(textApellido);
			listaLabelVacios.add(lblApellido);
		} else {
			listaTextNoVacios.add(textApellido);
			listaLabelNoVacios.add(lblApellido);
		}

		if (textNombre.getText().isEmpty()) {
			listaTextVacios.add(textNombre);
			listaLabelVacios.add(lblNombre);
		} else {
			listaTextNoVacios.add(textNombre);
			listaLabelNoVacios.add(lblNombre);
		}

		if (textNumeroDocumento.getText().isEmpty()) {
			listaTextVacios.add(textNumeroDocumento);
			listaLabelVacios.add(lblNumDocumento);
		} else {
			listaTextNoVacios.add(textNumeroDocumento);
			listaLabelNoVacios.add(lblNumDocumento);
		}

		if (textOcupacion.getText().isEmpty()) {
			listaTextVacios.add(textOcupacion);
			listaLabelVacios.add(lblOcupacion);
		} else {
			listaTextNoVacios.add(textOcupacion);
			listaLabelNoVacios.add(lblOcupacion);
		}

		if (textTelefono.getText().isEmpty()) {
			listaTextVacios.add(textTelefono);
			listaLabelVacios.add(lblTelefono);
		} else {
			listaTextNoVacios.add(textTelefono);
			listaLabelNoVacios.add(lblTelefono);
		}

		if (textEmail.getText().isEmpty()) {
			listaTextVacios.add(textEmail);
			listaLabelVacios.add(lblEmail);
		} else {
			listaTextNoVacios.add(textEmail);
			listaLabelNoVacios.add(lblEmail);
		}

		if (textNacionalidad.getText().isEmpty()) {
			listaTextVacios.add(textNacionalidad);
			listaLabelVacios.add(lblNacionalidad);
		} else {
			listaTextNoVacios.add(textNacionalidad);
			listaLabelNoVacios.add(lblNacionalidad);
		}

		if (textCalle.getText().isEmpty()) {
			listaTextVacios.add(textCalle);
			listaLabelVacios.add(lblCalle);
		} else {
			listaTextNoVacios.add(textCalle);
			listaLabelNoVacios.add(lblCalle);
		}

		if (textNum.getText().isEmpty()) {
			listaTextVacios.add(textNum);
			listaLabelVacios.add(lblNum);
		} else {
			listaTextNoVacios.add(textNum);
			listaLabelNoVacios.add(lblNum);
		}

		if (cuitActivo && textCuit.getText().isEmpty()) {
			listaTextVacios.add(textCuit);
			listaLabelVacios.add(lblCuit);
		} else {
			listaTextNoVacios.add(textCuit);
			listaLabelNoVacios.add(lblCuit);
		}

		listRetorno.add(listaTextVacios);
		listRetorno.add(listaTextNoVacios);
		listRetorno.add(listaLabelVacios);
		listRetorno.add(listaLabelNoVacios);

		return listRetorno;

	}

	public void eliminarPasajero(BusquedaPasajeroDTO pasajeroEliminar) {

	}

	public void modificarPasajero(BusquedaPasajeroDTO pasajeroEliminar) {

	}

}
