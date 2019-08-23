package com.tmsi.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {

	private long id;
	private String NameId;
	private String NimId;
    private String AlamatId;
    private String KelasId;
	
	public Mahasiswa() {
		
	}
	
	public Mahasiswa(String NameId, String NimId, String AlamatId, String KelasId) {
		this.NameId = NameId;
		this.NimId = NimId;
        this.AlamatId = AlamatId;
        this.KelasId = KelasId;
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
	
	@Column(name = "nim", nullable = false)
	public String getNimId() {
		return NimId;
	}
	public void setNimId(String NimId) {
		this.NimId = NimId;
	}
	
	@Column(name = "alamat", nullable = false)
	public String getAlamatId() {
		return AlamatId;
	}
	public void setAlamatId(String AlamatId) {
		this.AlamatId = AlamatId;
    }
    
    @Column(name = "kelas", nullable = false)
	public String getKelasId() {
		return KelasId;
	}
	public void setKelasId(String KelasId) {
		this.KelasId = KelasId;
    }

	@Override
	public String toString() {
        return "Mahasiswa [id=" + id + ", NameId=" + NameId + ", NimId=" + NimId + 
        ", AlamatId=" + AlamatId + ", KelasId=" + KelasId +" ]";
    }
}
