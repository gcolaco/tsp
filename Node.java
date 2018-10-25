public class Node {
	
	String path = "";
	int dist, level, city;
	Node[] children;
	
	public Node(String path, int city, int dist, int level, Node children[]){
		this.path = path;
		this.city = city;
		this.dist = dist;
		this.level = level;
		this.children = children;
	}
	
	public int getCity(){
		return city;
	}
	
	public Node[] getChildren(){
		return children;
	}
	
	public int getDist(){
		return dist;
	}
	
	public String getPath(){
		return path;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setChildren(Node children[]){
		this.children = children;
	}

}
