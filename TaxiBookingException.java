import java.util.*;


class TaxiNotAvailableException extends Exception {
    TaxiNotAvailableException(String msg){
        super(msg);
    }
}


class Trip{
    int bid,cid,pick,drop,amount;
    char from,to;

    Trip(int b,int c,char f,char t,int p,int d,int a){
        bid=b; cid=c; from=f; to=t; pick=p; drop=d; amount=a;
    }
}


class Taxi{
    int id;
    char location='A';
    int freeTime=0;
    int earnings=0;
    List<Trip> trips=new ArrayList<>();

    Taxi(int id){ this.id=id; }
}


public class TaxiBookingException {

    static int bookingId=1;

    static int pos(char c){ return c-'A'; }

    static int dist(char a,char b){
        return Math.abs(pos(a)-pos(b))*15;
    }

    static int fare(char a,char b){
        int d=dist(a,b);
        if(d<=5) return 100;
        return 100+(d-5)*10;
    }

    
    static void bookTaxi(List<Taxi> taxis,int cid,char from,char to,int time)
            throws TaxiNotAvailableException {

        if(from==to)
            throw new IllegalArgumentException("Pickup and Drop same!");

        if(from<'A'||from>'F'||to<'A'||to>'F')
            throw new IllegalArgumentException("Invalid location!");

        List<Taxi> free=new ArrayList<>();

        for(Taxi t:taxis){
            int reach=Math.abs(pos(t.location)-pos(from));
            if(t.freeTime+reach<=time) free.add(t);
        }

        if(free.isEmpty())
            throw new TaxiNotAvailableException(
                    "No taxi free at this time!");

        free.sort((a,b)->{
            int d1=Math.abs(pos(a.location)-pos(from));
            int d2=Math.abs(pos(b.location)-pos(from));
            if(d1!=d2) return d1-d2;
            return a.earnings-b.earnings;
        });

        Taxi taxi=free.get(0);

        int trip=Math.abs(pos(from)-pos(to));
        int drop=time+trip;
        int money=fare(from,to);

        taxi.location=to;
        taxi.freeTime=drop;
        taxi.earnings+=money;

        taxi.trips.add(new Trip(
                bookingId++,cid,from,to,time,drop,money));

        System.out.println("Taxi-"+taxi.id+" allotted successfully");
    }

   
    static void show(List<Taxi> taxis){

        for(Taxi t:taxis){

            System.out.println("\nTaxi-"+t.id+
                    " Earnings:"+t.earnings);

            for(Trip tr:t.trips){
                System.out.println(
                        tr.bid+" "+tr.cid+" "+
                        tr.from+" "+tr.to+" "+
                        tr.pick+" "+tr.drop+" "+tr.amount);
            }
        }
    }

   
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        List<Taxi> taxis=new ArrayList<>();
        for(int i=1;i<=4;i++) taxis.add(new Taxi(i));

        while(true){

            try{

                System.out.println("\n1.Book Taxi  2.Show  3.Exit");
                int ch=sc.nextInt();

                if(ch==1){

                    System.out.print("Customer ID:");
                    int cid=sc.nextInt();

                    System.out.print("Pickup(A-F):");
                    char f=sc.next().toUpperCase().charAt(0);

                    System.out.print("Drop(A-F):");
                    char t=sc.next().toUpperCase().charAt(0);

                    System.out.print("Time:");
                    int time=sc.nextInt();

                    bookTaxi(taxis,cid,f,t,time);
                }

                else if(ch==2) show(taxis);

                else break;
            }

            // --------- EXCEPTION HANDLING ----------
            catch(TaxiNotAvailableException e){
                System.out.println("BOOKING FAILED: "+e.getMessage());
            }

            catch(IllegalArgumentException e){
                System.out.println("INPUT ERROR: "+e.getMessage());
            }

            catch(InputMismatchException e){
                System.out.println("Enter correct datatype!");
                sc.nextLine();
            }

            catch(Exception e){
                System.out.println("Unknown error occurred");
                sc.nextLine();
            }
        }

        sc.close();
    }
}
