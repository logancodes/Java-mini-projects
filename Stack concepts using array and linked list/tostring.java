public String toString()
	{
		if(head==null)return "{}";
		String output="{";
		Node <T> temp=head;
		while(temp.next!=null)
		{
			output+=temp.item;
			if(temp.next!=null)
			{
				output+=",";
				
			}
			temp=temp.next;
			
		}
		return output+temp.item+"}";
	}
	public static void main(String[] args){
		LLStack<String> stack=new LLStack<String>();
		System.out.println(stack);
		try{
		stack.push("AAA");
		stack.push("LOLOLOL");
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack);
		}catch(StackEmptyException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
	}
