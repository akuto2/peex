package Akuto2.TileEntity;

public class TileEntityRelayFinal extends TileEntityRelayMk4 {
	public TileEntityRelayFinal(){
		super(20, Integer.MAX_VALUE, Integer.MAX_VALUE);
	}

	@Override
	public String getInventoryName(){
		return "relay.Final";
	}
}
