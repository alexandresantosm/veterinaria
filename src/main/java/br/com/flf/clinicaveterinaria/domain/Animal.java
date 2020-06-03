package br.com.flf.clinicaveterinaria.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.flf.clinicaveterinaria.domain.enums.TipoSex;

@Entity
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private int idade;
	private int sex;

	@ManyToOne
	@JoinColumn(name = "especie_id")
	@JsonIgnore
	private Especie especie;
	
	@ManyToOne
	@JoinColumn(name = "dono_id")
	private Cliente dono;
	
	@OneToMany(mappedBy = "animal")
	private List<Consulta> historico = new ArrayList<>();

	public Animal() {
	}

	public Animal(Integer id, String nome, int idade, TipoSex sex, Especie especie, Cliente dono) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.sex = sex.getCodigo();
		this.especie = especie;
		this.dono = dono;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public TipoSex getSex() {
		return TipoSex.toEnum(sex);
	}

	public void setSex(TipoSex sex) {
		this.sex = sex.getCodigo();
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
	}

	public List<Consulta> getHistorico() {
		return historico;
	}

	public void setHistorico(List<Consulta> historico) {
		this.historico = historico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
