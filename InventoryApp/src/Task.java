public class Task {
	
	public IQueue<IProduct> factory_line= new Factory<IProduct>(30);

	
	IStack<Bed> bedWarehouse= new Store<Bed>();
	IStack<Sofa> sofaWarehouse= new Store<Sofa>();
	IStack<Chair> chairWarehouse= new Store<Chair>();
	IStack<Dresser> dresserWarehouse= new Store<Dresser>();
	IStack<Table> tableWarehouse= new Store<Table>();
	IStack<Bookcase> bookcaseWarehouse= new Store<Bookcase>();
	
	
	public void Manager_Analysist(String furniture,int index) {
		
		switch (furniture) {
		case "Bed": {
			IProduct bed = new Bed();
			factory_line.enqueue(bed);
			IProduct elemanBed= factory_line.peek();
			if(elemanBed instanceof Bed)
				((Bed)elemanBed).setManufactured(true);
			break;
		}
		case "Sofa": {
			Sofa sofa= new Sofa();			
			factory_line.enqueue(sofa);
			IProduct elemanSofa = factory_line.peek();
			if(elemanSofa instanceof Sofa)
				((Sofa)elemanSofa).setManufactured(true);
			break;
		}
		case "Chair": {
			Chair chair = new Chair();
			factory_line.enqueue(chair);
			IProduct elemanChair =  factory_line.peek();
			if(elemanChair instanceof Chair)			
				((Chair)elemanChair).setManufactured(true);
						
			break;
		}
		case "Dresser": {
			Dresser dresser = new Dresser();
			factory_line.enqueue(dresser);
			IProduct elemanDresser = factory_line.peek();
			if(elemanDresser instanceof Dresser)
			     ((Dresser)elemanDresser).setManufactured(true);
			break;
		}
		case "Table": {
			Table table = new Table();
			factory_line.enqueue(table);
			IProduct elemanTable = factory_line.peek();
			if(elemanTable instanceof Table)
			      ((Table)elemanTable).setManufactured(true);
			
			break;
		}
		case "Bookcase": {
			Bookcase bookcase = new Bookcase();
			factory_line.enqueue(bookcase);
			IProduct elemanBookcase = factory_line.peek();
			if(elemanBookcase instanceof Bookcase)
				((Bookcase)elemanBookcase).setManufactured(true);
			
			break;
		}
		}
		System.out.println(index+". Marketing Analysist requested "+ furniture+ " ,SUCCESS!! "+ furniture+ " is manufactured.");
	}
	public void Storage_Chief(int index){
		String furniture="";
		IProduct top_elemanIProduct= (IProduct) factory_line.peek();
		if (top_elemanIProduct!=null) {	
			if (top_elemanIProduct instanceof Bed && !top_elemanIProduct.isStored()) {
				((Bed) top_elemanIProduct).setStored(true);
				bedWarehouse.push(((Bed) top_elemanIProduct));
				factory_line.dequeue();
				furniture="Bed";
			}
			
		
		
			else if (top_elemanIProduct instanceof Sofa && !top_elemanIProduct.isStored()) {
				((Sofa) top_elemanIProduct).setStored(true);
				sofaWarehouse.push(((Sofa) top_elemanIProduct));
				factory_line.dequeue();
				furniture="Sofa";
			}
			
		
		
			else if (top_elemanIProduct instanceof Chair && !top_elemanIProduct.isStored()) {
				((Chair) top_elemanIProduct).setStored(true);
				chairWarehouse.push(((Chair) top_elemanIProduct));
				factory_line.dequeue();
				furniture="Chair";
			}
			
			
		
		
			else if (top_elemanIProduct instanceof Dresser && !top_elemanIProduct.isStored()) {
				((Dresser) top_elemanIProduct).setStored(true);
				dresserWarehouse.push(((Dresser) top_elemanIProduct));
				factory_line.dequeue();
				furniture="Dresser";
			}
			
		
			else if (top_elemanIProduct instanceof Table && !top_elemanIProduct.isStored()) {
				((Table) top_elemanIProduct).setStored(true);
				tableWarehouse.push(((Table) top_elemanIProduct));
				factory_line.dequeue();
				furniture="Table";
			}
			
			
		
			else if (top_elemanIProduct instanceof Bookcase && !top_elemanIProduct.isStored()) {
				((Bookcase) top_elemanIProduct).setStored(true);
				bookcaseWarehouse.push(((Bookcase) top_elemanIProduct));
				factory_line.dequeue();
				furniture="Bookcase";
			}
			if (top_elemanIProduct.isStored() && furniture!="") {
				System.out.println(index+ ". Storage Chief is storing "+ furniture+ " ,SUCCESS!! "+ furniture + " stored in "+ furniture+ " warehouse");
			}
					
		}	
		else {
			System.out.println(index+ ". Storage Chief cannot store any product ,FAIL!! THERE IS NO PRODUCT IN THE PRODUCT LINE");			
		}
		
		
		
	}
	public void Customer(String product, int index) {
	    IProduct sellingIProduct=null;
		switch (product) {
		case "Bed": {
			if (!bedWarehouse.isEmpty()) {
				sellingIProduct=bedWarehouse.pop();
				((Bed) sellingIProduct).setSold(true);
				Bed.counter++;
				}
			break;
		}
		case "Sofa": {
			if (!sofaWarehouse.isEmpty()) {
				sellingIProduct=sofaWarehouse.pop();
				((Sofa) sellingIProduct).setSold(true);
				Sofa.counter++;
				}
			break;
		}
		case "Chair": {
			if (!chairWarehouse.isEmpty()) {
				sellingIProduct=chairWarehouse.pop();
				((Chair) sellingIProduct).setSold(true);
				Chair.counter++;
				}
			break;
		}
		case "Dresser": {
			if (!dresserWarehouse.isEmpty()) {
				sellingIProduct=dresserWarehouse.pop();
				((Dresser) sellingIProduct).setSold(true);
				Dresser.counter++;
				}
			break;
		}
		case "Table": {
			if (!tableWarehouse.isEmpty()) {
				sellingIProduct=tableWarehouse.pop();
				((Table) sellingIProduct).setSold(true);
				Table.counter++;
				}
			break;
		}
		case "Bookcase": {
			if (!bookcaseWarehouse.isEmpty()) {
				sellingIProduct=bookcaseWarehouse.pop();
				((Bookcase) sellingIProduct).setSold(true);
				Bookcase.counter++;
				}
			
			break;
		}
		}
		
		if (sellingIProduct!=null) {
			System.out.println(index+ ". Customer is buying "+ product+ " ,SUCCESS! "+product+ " is sold");
		}
		else {
			System.out.println(index+ ". Customer is buying "+ product+ " ,FAIL! "+product+ " cannot be sold");
		}			
		
		
		
	}
    public void Report() {
    	
    	int bed_counter=0,sofa_counter=0,dresser_counter=0,table_counter=0,chair_counter=0,bookcase_counter=0;
    	int index=((Factory<IProduct>)factory_line).getFront();
    	while (index <= ((Factory<IProduct>)factory_line).getRear()) {
    		if ( ((Factory<IProduct>)factory_line).get_eleman_by_index(index) instanceof Bed) {
    			bed_counter++;
			}
    		else if (((Factory<IProduct>)factory_line).get_eleman_by_index(index) instanceof Sofa) {
    			sofa_counter++;
			}
    		else if (((Factory<IProduct>)factory_line).get_eleman_by_index(index) instanceof Dresser) {
    			dresser_counter++;
			}
    		if (((Factory<IProduct>)factory_line).get_eleman_by_index(index) instanceof Table) {
    			table_counter++;
			}
    		if (((Factory<IProduct>)factory_line).get_eleman_by_index(index) instanceof Chair) {
    			chair_counter++;
			}
    		if (((Factory<IProduct>)factory_line).get_eleman_by_index(index) instanceof Bookcase) {
    			bookcase_counter++;
			}
    		
    		index++;
    	}
    	System.out.println("\nAmount of Bed in Factory Line : "+ bed_counter +"\r\n"
				+"Amount of Sofa in Factory Line : "+ sofa_counter +"\r\n"
				+"Amount of Dresser in Factory Line : "+ dresser_counter +"\r\n"
				+"Amount of Table in Factory Line : "+ table_counter +"\r\n"
				+"Amount of Chair in Factory Line : "+ chair_counter +"\r\n"
				+"Amount of Bookcase in Factory Line : "+ bookcase_counter +"\r\n");
    	
    	System.out.println("Amount of Bed in Bed Warehouse: "+((Store<Bed>) bedWarehouse).size()+ "\r\n"
    			+ "Amount of Sofa in Sofa Warehouse: "+((Store<Sofa>) sofaWarehouse).size()+ "\r\n"
    			+ "Amount of Dresser in Dresser Warehouse: " + ((Store<Dresser>)dresserWarehouse).size()+"\r\n"
    			+ "Amount of Table in Table Warehouse: " +((Store<Table>)tableWarehouse).size()+ "\r\n"
    			+ "Amount of Chair in Chair Warehouse: " +((Store<Chair>)chairWarehouse).size()+ "\r\n"
    			+ "Amount of Bookcase in Bookcase Warehouse: "+ ((Store<Bookcase>)bookcaseWarehouse).size()+ "\r\n"
    			+ "");
    	
    	System.out.println("Amount of Bed Sold: "+ Bed.counter+ "\r\n"
    			+ "Amount of Sofa Sold: "+ Sofa.counter+ "\r\n"
    			+ "Amount of Dresser Sold: " + Dresser.counter+"\r\n"
    			+ "Amount of Table Sold: " +Table.counter+ "\r\n"
    			+ "Amount of Chair Sold: " +Chair.counter+ "\r\n"
    			+ "Amount of Bookcase Sold: "+ Bookcase.counter+ "\r\n"
    			+ "");
    	
    }
}