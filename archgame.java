import java.util.Random;
import java.util.Scanner;

public  class archgame {
static user head;

public int[] generaterandomnumber() {
	Random rand=new Random();
	int[] arr=new int[3];
	int rand_int1=rand.nextInt(10);
	int rand_int2=rand.nextInt(10);
	int rand_int3=rand.nextInt(10);
	
	arr[0]=rand_int1;
	arr[1]=rand_int2;
	arr[2]=rand_int3;
	
	return arr;
	
}

	
//           CLASS USER

public static class user{
	final String name;
	private user next;
	private String hero;
	private hero h1;
	
	user(){
		name="";
	}
	
	user(String param1,String param2){
		this.name=param1;
		this.next=null;
		this.hero=param2;
		this.h1=new hero();              /// Composition relationship
	}
	
	public String getter_name() {
		return this.name;
	}
	
	public void getter_hero(String param3) {
		this.hero=param3;
	}
	
	public void setter_hero(String param4) {
		this.hero=param4;
	}

	public void displaydetails() {
		System.out.println("User Creation done. Username:  . Hero type:  . Log in to play the game. Exiting ");
	}
	
	public void adduser(String param1, String param2) {
		user temp=new user(param1,param2);
		if(head==null) {
			head=temp;
			
		}
		else {
			user temp2=head;
			while(temp2.next!=null) {
				temp2=temp2.next;
			}
			temp2.next=temp;
		}
	}
	
	
}


public class location{
	private monster m;     // association relationship
	final int location_number;
	private int num_of_monsters;
	private int[] monsters;
	location previous;
	location next;
	private int numlocations;
	
	
	location(){
		location_number=0;
		num_of_monsters=0;
		monsters=new int[10];
		int numlocations=3;
	}
	
	
	
	location(int param1,int param3,int param4) {
		this.location_number=param1;
		this.num_of_monsters=param3;
		this.numlocations=param4;
	}
	
	private String getter_monster() {
		return this.m.name;
	}
	private void setter_monster(monster m) {
		this.m=m;
	}
	
	private int getter_nummonster() {
		return this.num_of_monsters;
	}
	private void setter_nummonster(int m) {
		this.num_of_monsters=m;
	}
	
	private int getter_location() {
		return this.location_number;
	}
	private void setter_location(int m) {
		this.numlocations=m;            //
	}
	
	
	
	public void setterarr(int[] a) {
		for(int i=0;i<a.length;i++) {
			monsters[i]=a[i];
		}
	}
	
}

// CLASS HERO



public static  class hero{
	final String name;
	protected int XP;
	protected int HP;
	protected int level;
	protected int attack;
	protected int defence;
	protected int maxHP;
	protected int hp;
	protected int maxdef;

	

	
	hero(){
		this.name="";
	}
	
	public String gettername() {
		return this.name;
	}
	
	public  int getterXP() {
		return this.XP;
	}
	
	
	
	public void setlevel() {
		if(XP>=20 && XP<40) {
			this.level=2;
			this.HP=150;
			
		}
		if(XP>=40 && XP<60) {
			this.level=3;
			this.HP=200;
		}
		if(XP>=60) {
			this.level=4;
			this.HP=200;
		}
	}
	
	public void increaselevel() {
		this.attack+=1;
		this.defence+=1;
	}
	
	public void attack(monster m) {
		return;
	}
	
	public void defence() {
		return;
	}
	
	public void specialpower(monster m) {
		return;
	}
	
	public void kill(monster m) {
		this.XP+=m.level*20;
		this.HP=this.maxHP;
	}
	
	public void attacksidekick(sidekick s) {
		return; 
	}
	
	
	
	
}

public static class Warrior extends hero{
	
	Warrior(){
		
		this.XP=0;
		this.HP=100;
		this.level=0;
		this.hp=6;
		this.maxdef=3;
	}
	
	public void attack(monster m) {
		m.HP-=10;
	}
	
	public void defense() {
		this.HP+=3;
	}
	
	public void attacksidekick(sidekick s) {
		return; 
	}
	
	public void specialpower(monster m1) {        // 
	
	m1.HP-=15;
	this.HP+=3;
	
		
	}
	
}

public static class Thief extends hero{
	
	Thief(){
	
		this.XP=0;
		this.HP=100;
		this.level=0;
		this.hp=6;
		this.maxdef=4;
	}
	
	public void attack(monster m) {
		if((m.HP-6)>=0) {
		m.HP-=6;
		}
		else {
			m.HP=0;
		}
	}
	

	
	public void defense() {
		this.HP+=6;
	}

public void specialpower(monster m) {        // 
		
	
		
	int dummy=(int)(0.3*m.HP);
	this.HP+=dummy;
	m.HP-=dummy;
	System.out.println("You have stolen "+dummy+" HP from the monster!");
	
		
			
		}
	
}

	


public static class Mage extends hero{
	
	Mage(){
		
		this.XP=0;
		this.HP=100;
		this.level=0;
		this.hp=5;
		this.maxdef=5;
	}
	public void attack(monster m) {
		m.HP-=5;
	}
	
	public void defense() {
		this.HP+=5;
	}
	
public void specialpower(monster m1) {        // 
		
		m1.HP-=.05*m1.HP;
		
		
		
			
		}
	
}

public static class Healer extends hero{
	
	Healer(){
		
		this.XP=0;
		this.HP=100;
		this.level=0;
		this.hp=4;
		this.maxdef=8;
	}
	public void attack(monster m) {
		m.HP-=4;
	}
	
	public void defense() {
		this.HP+=4;
	}
	
public void specialpower(monster m1) {        // 
		
		this.HP+=0.5*this.HP;
		
		
		
			
		}
	
}


// MONSTERS CLASS

static public class monster{
	
	final String name;
	protected int HP;
	protected int level;
	
	monster(){
		this.name="";
	}
	
	public void attack(hero h1) {        
		Random rand=new Random();
		int dec=0;
		if(this.HP>=4) {
		int randint=rand.nextInt((int)(0.25*this.HP));
		h1.HP-=randint;
		dec=randint;
		}
		else {
			//h1.hp=0;
			dec=3;
			
		}
		if(h1.HP<0) {
			h1.HP=0;
		}
		
		//if(h1.HP>=4) {
		//int randint=rand.nextInt(( int)(0.25*this.HP));
		
		//if((h1.HP-randint)>=0) {
		//h1.HP-=randint;
		//}
		//else {
		//	h1.HP=0;
		//}
		System.out.println("");
		System.out.println("The monster attacked and inflicted "+dec+" damage to you.");
		
		
	}
	
	public void attackwdef(hero h1) {
		Random rand=new Random();
		int randint=rand.nextInt(( int)(0.25*this.HP));
		int displayint=randint-h1.maxdef;
		h1.HP=h1.HP-randint+h1.maxdef;
		
		
		System.out.println("");
		System.out.println("The monster attacked and inflicted "+displayint+" damage to you.");
		
	}
	
	@Override
	public boolean equals(Object o1) {
		if(o1!=null && getClass()==o1.getClass()) {
			monster o= (monster) o1;
			if (o.level==2){
				return true;
			}
			else return false;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
}

public static class goblins extends monster{
	
	goblins(){
	
	this.HP=100;
	this.level=1;
	}
}
public static  class Zombies extends monster{
	
	Zombies(){
	
	this.HP=100;
	this.level=2;
}
}
	public static class Fiends extends monster{
		
		Fiends(){
		
		this.HP=200;
		this.level=3;
		}
	
}

public static class Lionfang extends monster{
	
	Lionfang(){

	this.HP=250;
	this.level=4;
}
	
	public void attack(hero h1) {
		int flag=0;
		Random rand=new Random();
		int randd=rand.nextInt(10);
		if(randd==1) {
			flag=1;
		}
		
		if(flag==1) {
			h1.HP/=2;
		}
		else {
			int randint=rand.nextInt(1/4*this.HP);
			h1.HP-=randint;
		}
		
	}
	
	
	
}





// lab04 







public static class sidekick implements Comparable<sidekick>{
	
	private int XP;
	private int HP;
	private int maxattack;
	String name;
	
	sidekick(){
		this.XP=0;
		this.HP=100;
		this.maxattack=0;
	}
	
	
	public void setmaxattack(int param1) {
		this.maxattack=param1;
	}
	
	@Override
	public int compareTo(sidekick param1) {
		if(this.XP>=param1.XP) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	@Override
	public boolean equals(Object o1) {
		if(o1 instanceof sidekick ) {
			sidekick o=(sidekick) o1;
			return (this.XP==o.XP && this.HP==o.HP);
			
		}
		else {
			return false;
		}
	}
	
	public int getterHP() {
		return HP;
	}
	
	public int getterXP() {
		return XP;
	}
	
	public void setterHP(int param1) {
		this.HP=param1;
	}
	
	public void setterXP(int param1) {
		this.XP=param1;
	}
	
	public void attack(monster m) {
		
		m.HP-=this.maxattack;
		
	}
	
	
}

public static class minions extends sidekick implements Cloneable{
	
	public minions() {
		this.name="Minion";
	}
	public minions clone() {
		try{
			minions copy=(minions) super.clone();
			return copy;
		}
		catch(CloneNotSupportedException e) {
			return null;
		}
	}
	
}

public static  class knight extends sidekick{
	public knight() {
		this.name="knight";
	}
}








	
	

	
	
public static void main(String[] args) {
		// TODO Auto-generated method stub
user u=new user();
monster m=new monster();

Random rand=new Random();
sidekick s1=new sidekick();
Scanner input=new Scanner(System.in);
System.out.println("Welcome to ArchLegends");
System.out.println("Choose your options");
System.out.println("Welcome to ArchLegends");
System.out.println("1) New User");
System.out.println("2) Existing User");
System.out.println("3)Exit");
String inputaux1=input.nextLine();
int input1=Integer.parseInt(inputaux1);
if(input1==1) {
	int flag=0;
	System.out.println("Enter Username");
	String inputaux2=input.nextLine();
	
	System.out.println("Choose a Hero");
	System.out.println("1)Warrior");
	System.out.println("2)Thief");
	System.out.println("3)Mage");
	System.out.println("4)Healer");
	
	String inputaux3=input.nextLine();
	int input3=Integer.parseInt(inputaux3);
	String auxstr="";
	hero h1=new hero();
	if(input3==1) {
		auxstr="Warrior";
		h1=new Warrior();
	}
	else if(input3==2) {
		auxstr="Thief";
		h1=new Thief();
	}
	else if(input3==3) {
		auxstr="Mage";
		h1=new Mage();
	}
	else if(input3==4) {
		auxstr="Healer";
		
		h1=new Healer();
	}
	System.out.println("User Creation done. Username: "+ inputaux2+" . Hero type: "+ auxstr +" . Log in to play the game. Exiting ");
	u.adduser(inputaux1,auxstr);
	
	
	
	System.out.println("Welcome to ArchLegends");
	System.out.println("Choose your options");
	System.out.println("Welcome to ArchLegends");
	System.out.println("1) New User");
	System.out.println("2) Existing User");
	System.out.println("3)Exit");

	String inputaux4=input.nextLine();
	int input4=Integer.parseInt(inputaux4);
	
	if(input4==2) {
		System.out.println("Enter username");
		String inputaux5=input.nextLine();
		
		user temp3=head;
		while(temp3!=null) {
			if(temp3.name.contentEquals(inputaux5));
			{
				System.out.println("User found... logging in");
				flag=1;
				
			}
			temp3=temp3.next;
		}
		
		if(flag==1) {
			System.out.println("Welcome "+ inputaux5);
			
			System.out.println("You are at the starting location. Choose Path:");
			
			
			int rand_int1=rand.nextInt(10);
			
			int rand_int2=rand.nextInt(10);
			while(rand_int2==rand_int1) {
				rand_int2=rand.nextInt(10);
			}
			int rand_int3=rand.nextInt(10);
			while(rand_int2==rand_int3 || rand_int3==rand_int1) {
				rand_int3=rand.nextInt(10);
			}
			
			
			System.out.println("1) Go to location "+rand_int1);
			System.out.println("2) Go to location "+rand_int2);
			System.out.println("3) Go to location "+rand_int3);
			System.out.println("Enter -1 to exit ");
			
			
			String inputaux6=input.nextLine();
			int input6=Integer.parseInt(inputaux6);
			
			if(input6==1) {
				
				monster m1=new monster();
				
				int rand_int5=1+rand.nextInt(3);
				if(rand_int5==1) {
					 m1=new goblins();
					
				}
				if(rand_int5==2) {
					 m1=new Zombies();
					
				}
				
				if(rand_int5==3) {
					 m1=new Fiends();
					
				}
				
				if(rand_int5==4) {
				 m1=new Lionfang();
					
				}
				
				System.out.println("Moving to location "+ rand_int1);
				System.out.println("Fight started. You are fighting a level "+ rand_int5+ " Monster");
				int counterofmoves=1;
				
				// moves by both the players
				int flag2=0;
				while(h1.HP>=0 && m1.HP>=0) { ///
				
				if(counterofmoves%5!=0) {
				System.out.println("Choose move :");
				System.out.println("1) Attack");
				System.out.println("2) Defence");
				
				String inputaux7=input.nextLine();
				int input7=Integer.parseInt(inputaux7);
				if(input7==1) {
					h1.attack(m1);
					System.out.println("You choose to attack");
					System.out.println("You attacked and inflicted "+ h1.hp+ " damage");
					System.out.println("Your HP: "+h1.HP+" Monsters Hp: "+m1.HP);
					if(h1.HP==0) {
						System.out.println("You were killed");
						System.exit(0);
					}
					else if (m1.HP==0) {
						System.out.println("Monster killed!");
						h1.XP+=m1.level*20;
						if(h1.XP==20)
						{h1.HP=150;}
						else if(h1.XP==40) {
							h1.HP=200;
						}
						else if(h1.XP==60) {
							h1.HP=250;
						}
						flag2=1;
						break;
						
					}
					
					System.out.println("Monster attack!");
					m1.attack(h1);
					System.out.println(" Your HP "+ h1.HP+ " Monsters Hp: "+ m1.HP);
					if(h1.HP==0) {
						System.out.println("You were killed");
						System.exit(0);
					}
					else if (m1.HP==0) {
						System.out.println("Monster killed!");
						h1.XP+=m1.level*20;
						if(h1.XP==20)
						{h1.HP=150;}
						else if(h1.XP==40) {
							h1.HP=200;
						}
						else if(h1.XP==60) {
							h1.HP=250;
						}
						flag2=1;
						break;
					}
					
				}
				if(input7==2) {
					
					System.out.println("You choose to defend");
					System.out.println("Monster attack reduced by "+ h1.maxdef);
					System.out.println("Your HP: "+h1.HP+" Monsters Hp: "+m1.HP);
					System.out.println("Monster attack!");
					m1.attackwdef(h1);
					//h1.defence();
					System.out.println(" Your HP "+ h1.HP+ " Monsters Hp: "+ m1.HP);
					if(h1.HP==0) {
						System.out.println("You were killed");
						System.exit(0);
					}
					else if (m1.HP==0) {
						System.out.println("Monster killed!");
						h1.XP+=m1.level*20;
						if(h1.XP==20)
						{h1.HP=150;}
						else if(h1.XP==40) {
							h1.HP=200;
						}
						else if(h1.XP==60) {
							h1.HP=250;
						}
						flag2=1;
						break;
						
					}
			
				}
				}
				else if(counterofmoves%5==0) {
					
					System.out.println("Choose move :");
					System.out.println("1) Attack");
					System.out.println("2) Defence");
					System.out.println("3)Special Attack");
					
					String inputaux7=input.nextLine();
					int input7=Integer.parseInt(inputaux7);
					if(input7==1) {
						h1.attack(m1);
						System.out.println("You choose to attack");
						System.out.println("You attacked and inflicted "+ h1.hp+ " damage");
						System.out.println("Your HP: "+h1.HP+" Monsters Hp: "+m1.HP);
						if(h1.HP==0) {
							System.out.println("You were killed");
							System.exit(0);
						}
						else if (m1.HP==0) {
							System.out.println("Monster killed!");
							h1.XP+=m1.level*20;
							if(h1.XP==20)
							{h1.HP=150;}
							else if(h1.XP==40) {
								h1.HP=200;
							}
							else if(h1.XP==60) {
								h1.HP=250;
							}
							flag2=1;
							break;
							
						}	
						
						System.out.println("Monster attack!");
						m1.attack(h1);
						System.out.println(" Your HP "+ h1.HP+ " Monsters Hp: "+ m1.HP);
						if(h1.HP==0) {
							System.out.println("You were killed");
							System.exit(0);
						}
						else if (m1.HP==0) {
							System.out.println("Monster killed!");
							h1.XP+=m1.level*20;
							if(h1.XP==20)
							{h1.HP=150;}
							else if(h1.XP==40) {
								h1.HP=200;
							}
							else if(h1.XP==60) {
								h1.HP=250;
							}
							flag2=1;
							break;
							
						}
						
					}
					if(input7==2) {
						
						System.out.println("You choose to defend");
						System.out.println("Monster attack reduced by "+ h1.maxdef);
						System.out.println("Your HP: "+h1.HP+" Monsters Hp: "+m1.HP);
						System.out.println("Monster attack!");
						m1.attackwdef(h1);
						//h1.defence();
						System.out.println(" Your HP "+ h1.HP+ " Monsters Hp: "+ m1.HP);
						if(h1.HP==0) {
							System.out.println("You were killed");
							System.exit(0);
						}
						else if (m1.HP==0) {
							System.out.println("Monster killed!");
							h1.XP+=m1.level*20;
							if(h1.XP==20)
							{h1.HP=150;}
							else if(h1.XP==40) {
								h1.HP=200;
							}
							else if(h1.XP==60) {
								h1.HP=250;
							}
							flag2=1;
							break;
							
						}
				
					}
					if(input7==3) {
						
						System.out.println("Special Power activated");
						System.out.println("Performing Special Attack");
						h1.specialpower(m1);
						System.out.println("Your HP: "+h1.HP+" Monsters Hp: "+m1.HP);
						
						System.out.println("Monster attack!");
						m1.attack(h1);
						System.out.println(" Your HP "+ h1.HP+ " Monsters Hp: "+ m1.HP);
						System.out.println("Special power deactivated.");
						if(h1.HP==0) {
							System.out.println("You were killed");
							System.exit(0);
						}
						else if (m1.HP==0) {
							System.out.println("Monster killed!");
							h1.XP+=m1.level*20;
							if(h1.XP==20)
							{h1.HP=150;}
							else if(h1.XP==40) {
								h1.HP=200;
							}
							else if(h1.XP==60) {
								h1.HP=250;
							}
							flag2=1;
							break;
							
							
						}
					
					}
					
				}
				
				
				counterofmoves++;
				
				
				}//
/// input for lab 4
if(flag2==1) {
	System.out.println("Fight won proceed to the next location.");
	
	System.out.println("If you want to buy a sidekick, type yes. Else type no to upgrade level");
		String input12=input.nextLine();
	if(input12.contentEquals("yes")) {
		System.out.println("Your current XP is "+h1.XP);
		System.out.println("If you want to buy a minion, press 1");
		System.out.println("IF you want to buy a knight, press 2");
		sidekick s2=new minions();
		String inputaux13=input.nextLine();
		int input13=Integer.parseInt(inputaux13);
		if(input13==1) {
			System.out.println("XP to spend:");
			String inputaux14=input.nextLine();
			int input14=Integer.parseInt(inputaux14);
			s2.maxattack=input14-5;
			System.out.println("You bought a sidekick: minion");
			System.out.println("XP of sidekick is "+s2.XP);
			
			System.out.println("Attack of sidekick is "+s2.maxattack);
		
			System.out.println("You are at location "+rand_int1+ " Choose Path:");
			
			
			int rand_int10=rand.nextInt(10);
			
			int rand_int11=rand.nextInt(10);
			while(rand_int11==rand_int10) {
				rand_int2=rand.nextInt(10);
			}
			int rand_int12=rand.nextInt(10);
			while(rand_int11==rand_int12 || rand_int12==rand_int10) {
				rand_int12=rand.nextInt(10);
			}
			
			System.out.println("1) Go to location "+rand_int10);
			System.out.println("2) Go to location "+rand_int11);
			System.out.println("3) Go to location "+rand_int12);
			System.out.println("Enter -1 to exit ");
			
			
			String inputaux15=input.nextLine();
			int input15=Integer.parseInt(inputaux15);
			if(input15==1) {
				System.out.println("Moving to location "+rand_int10);
monster m2=new monster();
				
				int rand_int6=1+rand.nextInt(3);
				if(rand_int6==1) {
					 m2=new goblins();
					
				}
				if(rand_int6==2) {
					 m2=new Zombies();
					
				}
				
				if(rand_int6==3) {
					 m2=new Fiends();
					
				}
				
				if(rand_int6==4) {
				 m2=new Lionfang();
					
				}
				System.out.println("Fight Started. You are fighting a level "+rand_int6+ " Monster");
			
				System.out.println("Type yes if you wish to use a sidekick, else type no");
				String input17=input.nextLine();
				if(input17.contentEquals("yes"));
				System.out.println("You have a sidekick "+s2.name+" with you. Attack of sidekick is "+s2.maxattack);
				if(s2.name.contentEquals("Minion")) {
					System.out.println("Press c to use cloning ability. Else press f to move to the fight");
					String input18=input.nextLine();
					if(input18.contentEquals("c")) {
						System.out.println("Cloning done");
						
						
						
						int counterofmoves2=1;
						
						while(h1.HP>=0 && m2.HP>=0) { ///
							
							if(counterofmoves2%5!=0) {
							System.out.println("Choose move :");
							System.out.println("1) Attack");
							System.out.println("2) Defence");
							
							String inputaux7=input.nextLine();
							int input7=Integer.parseInt(inputaux7);
							if(input7==1) {
								h1.attack(m2);
								System.out.println("You choose to attack");
								System.out.println("You attacked and inflicted "+ h1.hp+ " damage");
								System.out.println("Sidekick attacked and inflicted "+s2.maxattack+" damage to the monster");
								System.out.println("Sidekick attacked and inflicted "+s2.maxattack+" damage to the monster");
								System.out.println("Sidekick attacked and inflicted "+s2.maxattack+" damage to the monster");
								System.out.println("Sidekick attacked and inflicted "+s2.maxattack+" damage to the monster");
								s2.attack(m2);
								s2.attack(m2);
								s2.attack(m2);
								s2.attack(m2);
								
								System.out.println("Sidekick HP: "+s2.HP+"/100");
								System.out.println("Sidekick HP: "+s2.HP+"/100");
								System.out.println("Sidekick HP: "+s2.HP+"/100");
								System.out.println("Sidekick HP: "+s2.HP+"/100");
								
								System.out.println("Your HP: "+h1.HP+" Monsters Hp: "+m2.HP);
								if(h1.HP==0) {
									System.out.println("You were killed");
									System.exit(0);
								}
								else if (m2.HP==0) {
									System.out.println("Monster killed!");
									h1.XP+=m2.level*20;
									h1.HP=h1.maxHP;
									flag2=1;
									
									
								}
								int firsthp=h1.HP;
								
								System.out.println("Monster attack!");
								m2.attack(h1);
								
								int secondhp=h1.HP;
								int difference=firsthp-secondhp;
								s2.HP-=difference*1.5;
								//h1.HP=h1.maxHP;
								System.out.println(" Your HP "+ h1.HP+ " Monsters Hp: "+ m2.HP);
								System.out.println("Sidekick's HP: "+s2.HP+"/100");
								System.out.println("Sidekick's HP: "+s2.HP+"/100");
								System.out.println("Sidekick's HP: "+s2.HP+"/100");
								System.out.println("Sidekick's HP: "+s2.HP+"/100");
								
								if(h1.HP==0) {
									System.out.println("You were killed");
									System.exit(0);
								}
								else if (m2.HP==0) {
									System.out.println("Monster killed!");
									h1.XP+=m2.level*20;
									h1.HP=h1.maxHP;
									flag2=1;
									
									
								}
								
							}
							if(input7==2) {
								
								System.out.println("You choose to defend");
								System.out.println("Monster attack reduced by "+ h1.maxdef);
								System.out.println("Your HP: "+h1.HP+" Monsters Hp: "+m2.HP);
								System.out.println("Monster attack!");
								m2.attackwdef(h1);
								//h1.defence();
								System.out.println(" Your HP "+ h1.HP+ " Monsters Hp: "+ m2.HP);
								if(h1.HP==0) {
									System.out.println("You were killed");
									System.exit(0);
								}
								else if (m2.HP==0) {
									System.out.println("Monster killed!");
									h1.XP+=m2.level*20;
									h1.HP=h1.maxHP;
									flag2=1;
									
									
								}
						
							}
							}
							else if(counterofmoves2%5==0) {
								
								System.out.println("Choose move :");
								System.out.println("1) Attack");
								System.out.println("2) Defence");
								System.out.println("3)Special Attack");
								
								String inputaux7=input.nextLine();
								int input7=Integer.parseInt(inputaux7);
								if(input7==1) {
									h1.attack(m2);
									System.out.println("You choose to attack");
									System.out.println("You attacked and inflicted "+ h1.hp+ " damage");
									System.out.println("Your HP: "+h1.HP+" Monsters Hp: "+m2.HP);
									if(h1.HP==0) {
										System.out.println("You were killed");
										System.exit(0);
									}
									else if (m2.HP==0) {
										System.out.println("Monster killed!");
										h1.XP+=m2.level*20;
										h1.HP=h1.maxHP;
										flag2=1;
										
										
									}	
									
									System.out.println("Monster attack!");
									m2.attack(h1);
									System.out.println(" Your HP "+ h1.HP+ " Monsters Hp: "+ m2.HP);
									if(h1.HP==0) {
										System.out.println("You were killed");
										System.exit(0);
									}
									else if (m2.HP==0) {
										System.out.println("Monster killed!");
										h1.XP+=m2.level*20;
										h1.HP=h1.maxHP;
										flag2=1;
										
										
									}
									
								}
								if(input7==2) {
									
									System.out.println("You choose to defend");
									System.out.println("Monster attack reduced by "+ h1.maxdef);
									System.out.println("Your HP: "+h1.HP+" Monsters Hp: "+m2.HP);
									System.out.println("Monster attack!");
									m2.attackwdef(h1);
									//h1.defence();
									System.out.println(" Your HP "+ h1.HP+ " Monsters Hp: "+ m2.HP);
									if(h1.HP==0) {
										System.out.println("You were killed");
										System.exit(0);
									}
									else if (m2.HP==0) {
										System.out.println("Monster killed!");
										h1.XP+=m2.level*20;
										h1.HP=h1.maxHP;
										flag=1;
										
										
									}
							
								}
								if(input7==3) {
									
									System.out.println("Special Power activated");
									System.out.println("Performing Special Attack");
									h1.specialpower(m2);
									System.out.println("Your HP: "+h1.HP+" Monsters Hp: "+m2.HP);
									
									System.out.println("Monster attack!");
									m2.attack(h1);
									System.out.println(" Your HP "+ h1.HP+ " Monsters Hp: "+ m2.HP);
									System.out.println("Special power deactivated.");
									if(h1.HP==0) {
										System.out.println("You were killed");
										System.exit(0);
									}
									else if (m2.HP==0) {
										System.out.println("Monster killed!");
										h1.XP+=m2.level*20;
										h1.HP=h1.maxHP;
										flag2=1;
										break;
										
										
									}
								
								}
								
							}
							
							
							counterofmoves2++;
							
							
							}//
						
						
						
						
					}
				}
				
			
				
			}
			
			
		}
	
	
	
	}
	
	
	
	
	
}
				
				
				
				
				
			}
			
			
		}
		
	}


}



		
		
		
		
	}


}

