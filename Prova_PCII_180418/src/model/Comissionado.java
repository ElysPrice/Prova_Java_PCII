package model;

public class Comissionado {
	private float totalVenda;
	private float taxaComissao;
	
	/*public float vencimento() {
		return;
	}*/
	
	public float getTotalVenda() {
		return totalVenda;
	}
	public void setTotalVenda(float totalVenda) {
		this.totalVenda = totalVenda;
	}
	public float getTaxaComissao() {
		return taxaComissao;
	}
	public void setTaxaComissao(float taxaComissao) {
		this.taxaComissao = taxaComissao;
	}
}
