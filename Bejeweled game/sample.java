if(cmd.equals("u") && row == 0)  return false;
		else if(cmd.equals("d")&& row==7)return false;
		else if(cmd.equals("l")&& col==0)return false;
		else if(cmd.equals("r")&& col==7)return false;
		else 				 return true;
