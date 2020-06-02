package br.com.flf.clinicaveterinaria.domain.enums;

public enum TipoSex {
	MACHO(1, "Macho"),
	FÊMEA(2, "Fêmea");

	private int codigo;
	private String descrição;

	private TipoSex(int codigo, String descrição) {
		this.codigo = codigo;
		this.descrição = descrição;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescrição() {
		return descrição;
	}

	public static TipoSex toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}

		for (TipoSex tipoSex : TipoSex.values()) {
			if (codigo.equals(tipoSex.getCodigo())) {
				return tipoSex;
			}
		}
		throw new IllegalArgumentException("Código para tipo de sexo inválido. Código: " + codigo);
	}
}
