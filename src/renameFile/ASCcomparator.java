package renameFile;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ASCcomparator implements Comparator<String> {
	private boolean order = true;
	

	public boolean isOrder() {
		return order;
	}


	public void setOrder(boolean order) {
		this.order = order;
	}
	

	public ASCcomparator(boolean order) {
		super();
		this.order = order;
	}





	@Override
	public int compare(String o1, String o2) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher matcher = pattern.matcher(o1);
		Matcher matcher2 = pattern.matcher(o2);
		int a = 0,b=0;
		while(matcher.find()) 
	          if(!matcher.group().equals(""))
	              a = Integer.parseInt(matcher.group(0));
		while(matcher2.find()) 
	          if(!matcher2.group().equals(""))
	              b = Integer.parseInt(matcher2.group(0));
		if(isOrder())
			return a-b;
		else
			return b-a;
//		long targetOne = Long.parseLong(o1.substring(0,o1.lastIndexOf(".")));
//		long targetTwo = Long.parseLong(o2.substring(0,o2.lastIndexOf(".")));
//		
//		if(isOrder())
//			return  new Long(targetOne - targetTwo).intValue();
//		else 
//			return  new Long(targetTwo - targetOne).intValue();
	}

}
