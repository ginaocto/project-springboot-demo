package com.tmsi.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dosen")
public class Dosen {

	private long id;
	private String NameId;
	private String NikId;
    private String AlamatId;
    private String EmailId;
	
	public Dosen() {
		
	}
	
	public Dosen(String NameId, String NikId, String AlamatId, String EmailId) {
		this.NameId = NameId;
		this.NikId = NikId;
        this.AlamatId = AlamatId;
        this.EmailId = EmailId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getNameId() {
		return NameId;
	}
	public void setNameId(String NameId) {
		this.NameId = NameId;
	}
	
	@Column(name = "nik", nullable = false)
	public String getNikId() {
		return NikId;
	}
	public void setNikId(String NikId) {
		this.NikId = NikId;
	}
	
	@Column(name = "alamat", nullable = false)
	public String getAlamatId() {
		return AlamatId;
	}
	public void setAlamatId(String AlamatId) {
		this.AlamatId = AlamatId;
    }
    
    @Column(name = "email", nullable = false)
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String EmailId) {
		this.EmailId = EmailId;
    }

	@Override
	public String toString() {
        return "Dosen [id=" + id + ", NameId=" + NameId + ", NikId=" + NikId + 
        ", AlamatId=" + AlamatId + ", EmailId=" + EmailId+" ]";
    }
}
