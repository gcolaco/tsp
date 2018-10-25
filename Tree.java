public class Tree {

	int height;
	boolean choosen[];
	Node root;
	Node sheets[];
	Tree subTree[];
	
	public Tree(Node root, int height, Node sheets[]){
		
		this.root = root;
		this.height = height;
		this.sheets = sheets;
		choosen = new boolean[height];
		
		for(int i = 0; i < height; i++){
			if(i == root.getCity()){
				choosen[i] = true;
			}else{
				choosen[i] = false;
			}
		}

		subTree = (height > 1)? new Tree[height-1] : null;
	
	}
	
	private Tree(Node root, int height, boolean selec[], Node sheets[]){
		
		this.root = root;
		this.height = height;
		this.sheets = sheets;
		choosen = selec;
		subTree = (height > 2)? new Tree[height-1] : null;
	
	}
	
	public void addNodes(Node n){
		if(subTree == null){
			return;
		}
		
		int i = 0, c = 0;

		for(int j = 0; j < choosen.length; j++){
			if(choosen[j])
				c++;
		}

		System.out.println(c);
		

		do{

			System.out.println(i);
			while(i < choosen.length-1 && subTree[i] != null)
				i++;

			if(i < choosen.length && !choosen[i+1] ){

				subTree[i] = new Tree(n, height-1, choosen.clone(), sheets);
				choosen[i+1] = false;

				break;
			}else{
				System.out.println("Pulo");
				i++;
			}
		}while(i < choosen.length-1);
	}
	
	public int construct(int vet[][], int size){
		
		int res = 0, dist, nivel = root.getLevel();
		String caminho;

		showChoosen();

		for(int i = 1; i < size; i++){
			System.out.print("i: " + i);
			dist = root.getDist();
			dist += vet[root.getCity()][i];
			System.out.print(", dist: " + dist);
			if(dist == 0 || choosen[i]){
				System.out.println(" endl");
				continue;
			}
			
			caminho = root.getPath() + " " + i;
			System.out.print(", path: " + caminho);
			nivel = root.getLevel();
			System.out.println(", nivel: " + (nivel+1));
			addNodes(new Node(caminho, i, dist, nivel+1, new Node[size-1]));
			
		}
		
		
		for(int i = 0; i < height-1; i++){
			if(subTree[i]== null){
				System.out.println("NULL");
				continue;
			}

			subTree[i].construct(vet, size);
		}
		
		return 0;
		
	}
	

	public void showChoosen(){
		System.out.print("Choosen: ");
		for(int i = 0; i < height; i++){
			if(choosen[i])
				System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public void showTree(){
		
		System.out.println("Nivel " + root.getLevel() + " - \t No: " + root.getCity() + " Path: " + root.getPath());
		for(Tree subt : subTree){
			subt.showTree();
		}
		
	}
	
	
}
