package problema3;

import java.util.ArrayList;

public class SEDEX extends TipoEntrega {
	
	private static SEDEX instance;

	private SEDEX() {
		
	}
	
	@Override
	public double getValorEntrega(ArrayList<ItemPedido> itens) throws TipoEntregaInvalido {
		
		int peso = getPesoTotal(itens);

		if (peso <= 1000) {
			return 10;
		} else if (peso <= 2000) {
			return 15;
		} else if (peso <= 3000) {
			return 20;
		} else if (peso <= 5000) {
			return 30;
		}
		
		throw new TipoEntregaInvalido();
		
	}
	
	public static TipoEntrega getInstance() {
		if(instance == null) {
			instance = new SEDEX();
		}
		return instance;
	}

}
