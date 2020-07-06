package akuto2.asm;

import java.util.Map;
import java.util.logging.Logger;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

public class PEEXCorePlugin implements IFMLLoadingPlugin{

	public static Logger logger = Logger.getLogger("PEEX");

	@Override
	public String[] getASMTransformerClass() {
		return new String[] { "akuto2.asm.transform.TransformerObjHandler" };
	}

	@Override
	public String getModContainerClass() {
		return null;
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {}

	@Override
	public String getAccessTransformerClass() {
		return null;
	}
}