package paciente;

import java.util.ArrayList;
import java.util.Date;

public class Paciente {
	

	private ArrayList<Paciente> consultorio = new ArrayList<Paciente>();
	private String cve_pac;
	private String aps_pac;
	private String nom_pac;
	private Date fnac_pac;
	private String corr_pac;
	private String tel_pac;
	
	public Paciente(String cve_pac, String aps_pac, String nom_pac, Date fnac_pac, String corr_pac, String tel_pac) { 
		this.cve_pac = cve_pac;
		this.aps_pac = aps_pac;
		this.nom_pac = nom_pac;
		this.fnac_pac = fnac_pac;
		this.corr_pac = corr_pac;
		this.tel_pac = tel_pac;
	}
	// Getters y Setters
	public String getCve_pac() {
		return cve_pac;
	}

	public void setCve_pac(String cve_pac) {
		this.cve_pac = cve_pac;
	}

	public String getAps_pac() {
		return aps_pac;
	}

	public void setAps_pac(String aps_pac) {
		this.aps_pac = aps_pac;
	}

	public String getNom_pac() {
		return nom_pac;
	}

	public void setNom_pac(String nom_pac) {
		this.nom_pac = nom_pac;
	}

	public Date getFnac_pac() {
		return fnac_pac;
	}

	public void setFnac_pac(Date fnac_pac) {
		this.fnac_pac = fnac_pac;
	}

	public String getCorr_pac() {
		return corr_pac;
	}

	public void setCorr_pac(String corr_pac) {
		this.corr_pac = corr_pac;
	}

	public String getTel_pac() {
		return tel_pac;
	}

	public void setTel_pac(String tel_pac) {
		this.tel_pac = tel_pac;
	}
	
	public ArrayList<Paciente> getClientes() {
		return consultorio;
	}
	public void setClientes(ArrayList<Paciente> consultorio) {
		this.consultorio = consultorio;
	}
	

}
