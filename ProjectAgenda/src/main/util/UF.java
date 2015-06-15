package util;

public enum UF {

	MT("Mato Grosso", "MT"), AC("Acre", "AC"), AL("Alagoas", "AL"),
	AP("Amapá", "AP"), AM("Amazônia", "AM"), BA("Bahia", "BA"),
	CE("Ceará", "CE"), DF("Distrito Federal", "DF"), ES("Espírito Santo", "ES"),
	GO("Goiás", "GO"), MA("Maranhão", "MA"), MS("Mato Grosso do Sul", "MS"),
	MG("Minas Gerais", "MG"), PA("Pará", "PA"), PB("Paraíba", "PB"),
	PR("Paraná", "PR"), PE("Pernambuco", "PE"), PI("Piauí", "PI"),
	RJ("Rio de Janeiro", "RJ"), RN("Rio Grande do Norte", "RN"), RS("Rio Grande do Sul", "RS"),
	RO("Rondônia", "RO"), RR("Roraima", "RR"), SC("Santa Catarina", "SC"),
	SP("São Paulo", "SP"), SE("Sergipe", "SE"), TO("Tocantins", "TO");

	private String descricao;
	private String sigla;

	private UF(String descricao, String sigla) {
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
