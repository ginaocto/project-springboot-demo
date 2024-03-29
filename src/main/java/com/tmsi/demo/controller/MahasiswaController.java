package com.tmsi.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmsi.demo.exception.ResourceNotFoundException;
import com.tmsi.demo.model.Mahasiswa;
import com.tmsi.demo.repository.MahasiswaRepository;

@RestController
@RequestMapping("/api/v1")
public class MahasiswaController {
	@Autowired
	private MahasiswaRepository mahasiswaRepository;

	@GetMapping("/mahasiswa")
	public List<Mahasiswa> getAllMahasiswa() {
		return mahasiswaRepository.findAll();
	}

	@GetMapping("/mahasiswa/{id}")
	public ResponseEntity<Mahasiswa> getMahasiswaById(@PathVariable(value = "id") Long mahasiswaId)
			throws ResourceNotFoundException {
		Mahasiswa mahasiswa = mahasiswaRepository.findById(mahasiswaId)
				.orElseThrow(() -> new ResourceNotFoundException("Mahasiswa not found for this id :: " + mahasiswaId));
		return ResponseEntity.ok().body(mahasiswa);
	}

	@PostMapping("/mahasiswa")
	public Mahasiswa createMahasiswa(@Valid @RequestBody Mahasiswa mahasiswa) {
		return mahasiswaRepository.save(mahasiswa);
	}

	@PutMapping("/mahasiswa/{id}")
	public ResponseEntity<Mahasiswa> updateMahasiswa(@PathVariable(value = "id") Long mahasiswaId,
			@Valid @RequestBody Mahasiswa mahasiswaDetails) throws ResourceNotFoundException {
		Mahasiswa mahasiswa = mahasiswaRepository.findById(mahasiswaId)
				.orElseThrow(() -> new ResourceNotFoundException("Mahasiswa not found for this id :: " + mahasiswaId));

		mahasiswa.setNameId(mahasiswaDetails.getNameId());
		mahasiswa.setNimId(mahasiswaDetails.getNimId());
        mahasiswa.setAlamatId(mahasiswaDetails.getAlamatId());
        mahasiswa.setKelasId(mahasiswaDetails.getKelasId());
		final Mahasiswa updatedMahasiswa = mahasiswaRepository.save(mahasiswa);
		return ResponseEntity.ok(updatedMahasiswa);
	}

	@DeleteMapping("/mahasiswa/{id}")
	public Map<String, Boolean> deleteMahasiswa(@PathVariable(value = "id") Long mahasiswaId)
			throws ResourceNotFoundException {
		Mahasiswa mahasiswa = mahasiswaRepository.findById(mahasiswaId)
				.orElseThrow(() -> new ResourceNotFoundException("Mahasiswa not found for this id :: " + mahasiswaId));

        mahasiswaRepository.delete(mahasiswa);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
