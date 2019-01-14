public class Sekigae06{
static int not,stu;
static int[][] seki;
static int[] flag;
static int[] flag2;

 public static void main(String[] args){
  int gyo,retu,x,y,i,a,b,eye,num;
  System.out.printf("縦は?\n");
  x=Keyboard.intValue();
  System.out.printf("横は?\n");
  y=Keyboard.intValue();
  while(true){
   System.out.printf("生徒の総数は?\n");
   stu=Keyboard.intValue();
   if(stu>(x*y)) System.out.printf("error! 生徒数が総席数を上回りました\n");
   else break;
  }
  while(true){
   System.out.printf("目が悪い人の総数は?\n");
   eye=Keyboard.intValue();
   if(eye>stu)   System.out.printf("error!　目が悪い人の総数が生徒数を上回りました\n");
   else break;
  }
  not=x*y-stu;

    seki=new int[x+1][y+1];
    for(gyo=0;gyo<=x;gyo++)
     for(retu=0;retu<=y;retu++)
      seki[gyo][retu]=0;

    System.out.printf("席がない場所を指定します\n");
    for(i=1;i<=not;i++){
      System.out.printf("席がない場所(%d/%d)\n",i,not);
      System.out.printf("何行目ですか?\n");
      a=Keyboard.intValue();
      System.out.printf("何列目ですか?\n");
      b=Keyboard.intValue();
      if(seki[a][b]==-1){
        System.out.printf("error!　その席は既に入力済みです\n");
        i--;
      }
      else seki[a][b]=-1;
    }
    flag=new int[stu+1];
      flag[0]=1;
      for(i=1;i<=stu;i++) flag[i]=0;

   flag2=new int[stu+1];
   for(i=1;i<=stu;i++) flag2[i]=0;

   for(i=1;i<=eye;i++){
     System.out.printf("目が悪い人の出席番号を入力してください(%d/%d)\n" ,i,eye);
     num=Keyboard.intValue();
     if(flag2[num]==0){
       flag2[num]=1;
     }
     else{
       System.out.printf("error!　その出席番号は既に入力済みです\n");
       i--;
       flag2[num]=2;
     }
     if(flag2[num]==1){
      while(true){
       a=(int)(Math.random()*(eye/(y+1))+1);
       b=(int)(Math.random()*y);
        if(seki[a][b]==0){
         seki[a][b]=num;
         flag[num]=1;
         break;
        }
     }
    }
  }
  for(gyo=1;gyo<=x;gyo++){
    for(retu=1;retu<=y;retu++){
      if(seki[gyo][retu]==0) seki[gyo][retu]=number(gyo,retu);
      if(seki[gyo][retu]>0){
         System.out.printf("%3d",seki[gyo][retu]);
      }
      else{
         System.out.printf("  X");
      }
    }
    System.out.printf("\n");
     }
   }
   public static int number(int g,int r){
     int i,num;
     num=1;

       while(true){
         num=(int)(Math.random()*(stu+1));
         if(flag[num]==0){
           flag[num]=1;
           break;
         }
       }
       return num;
   }
 }
