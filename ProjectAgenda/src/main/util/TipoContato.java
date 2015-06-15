package util;

public enum TipoContato {

	TEL("Telefone", "TEL"), CEL("Celular", "CEL"), FAX("Fax", "FAX");

	private String descricao;
	private String sigla;

	private TipoContato(String descricao, String sigla) {
		this.descricao = descricao;
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getSigla() {
		return sigla;
	}

}
