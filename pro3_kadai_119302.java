//オブジェクトの宣言
Ball b1;
Ball b2;
Player p1;
Rect r1; 
Start_text st;
Retry_text re;

int gseq;
int px;
int py;
int pw;
int ph;  
int x;
int y;
int blw;
int blh;
int blx;
int bly;
float lastx;
float lasty;
float xspeed;
float yspeed;
int bexist = 0;
int[] blf = new int [100];
int score;
int mcnt;

void setup(){ //プログラム開始時に1回限り実行
  size(400, 600); //window width（幅）、height（高さ）
  noStroke();
  gameInit();
}
  

void draw(){ //プログラム開始後、繰り返し実行
  background(0);
  if(gseq == 0){
    gameTitle(); 
  }
  else if(gseq == 1){
    gamePlay();    
  }
  else{
    gameOver(); 
  }
}

void gameInit(){
  gseq = 0;
  score = 0;
  mcnt = 0;
  //オブジェクトの定義
  p1 = new Player(170, 550, 60, 5);
  b1 = new Ball(120, 320, 4, 6);
  r1 = new Rect(39, 20);
  st = new Start_text(20, 0, 255, 255, 140, 400);
  re = new Retry_text(20, 255, 0, 255, 140, 400);
}


void gameTitle(){
  p1.playerDisp();
  b1.ballDisp();
  r1.rectDisp();
  scoreDisp();
  st.textblinking();
}

void gamePlay(){
  p1.playerDisp();
  p1.playerMove();
  
  b1.ballDisp();
  b1.ballMove();
  b1.ballHit();
  
  r1.rectDisp();
  scoreDisp();
}

void gameOver(){
  p1.playerDisp();
  r1.rectDisp();
  scoreDisp();
  textSize(50);
  fill(255, 0, 0);
  text("GAME OVER", 60, 350);
  re.textblinking();
}

void scoreDisp(){
  textSize(24);
  fill(255);
  text("score:"+score, 10, 25);
}

void mousePressed(){
  if(gseq == 0){
    gseq = 1;
  }
  if(gseq == 2){
    gameInit();
  }
}