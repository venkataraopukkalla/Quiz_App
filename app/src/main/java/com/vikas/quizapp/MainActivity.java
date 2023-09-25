package com.vikas.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CardView  cardA,cardB,cardC,cardD;
    private TextView questionBtn,optionA_Btn,optionB_Btn,optionC_Btn,optionD_Btn,showTotalTime;
    ProgressBar progressBar;
    private Button nextBtn;
    private boolean isItAlreadyPress=false,onTimeSelectOPtion=true;
    private CountDownTimer countDownTimer1;
      int size=0;
      static int  totalScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declarAll();

        progressBar=findViewById(R.id.progress_bar);
        //this method use to set timer of progressBar
        showTimerTotalQuiz();
        List<Quiz> questions=new ArrayList<>();
        horizProgressBarTimer(questions);
        //All quiz questions
        QuizQuestions(questions);
      questionBtn.setText(questions.get(0).getQuestion());
      optionA_Btn.setText(questions.get(0).getOptionA());
      optionB_Btn.setText(questions.get(0).getOptionB());
      optionC_Btn.setText(questions.get(0).getOptionC());
      optionD_Btn.setText(questions.get(0).getOptionD());
      //if u press next btn
      nextBtn.setOnClickListener(e->questionAndAnsDisplay(questions));
      // after showing question below four otions btn -select only one option enable
      optionA_Btn.setOnClickListener(e->{
           if(!isItAlreadyPress) {
               //to check selected option and ans is same are not
               if (checkCorrectAns(questions, optionA_Btn)) {
                   cardA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correctAns));
                    totalScore++;

               } else
                   cardA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.wrongAns));
           }
           //its means u pressed one option btn so,diable options that means alreadypress set as true
           isItAlreadyPress = true;

      });
      optionB_Btn.setOnClickListener(e->{
          if(!isItAlreadyPress){
              if (checkCorrectAns(questions, optionB_Btn)) {
                  cardB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correctAns));
                   totalScore++;
              } else
                  cardB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.wrongAns));
          }
              isItAlreadyPress=true;

      });
      optionC_Btn.setOnClickListener(e->{
          if(!isItAlreadyPress){
              if (checkCorrectAns(questions, optionC_Btn)) {
                  cardC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correctAns));
                   totalScore++;
              } else
                  cardC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.wrongAns));
          }
              isItAlreadyPress=true;

      });
      optionD_Btn.setOnClickListener(e->{
          if(!isItAlreadyPress){
              if (checkCorrectAns(questions, optionD_Btn)) {
                  cardD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correctAns));
                   totalScore++;
              } else
                  cardD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.wrongAns));
          }
              isItAlreadyPress=true;

      });
        Log.i("scoreCheck",totalScore+"");


    }
    private void questionAndAnsDisplay(List<Quiz> questions){
        horizProgressBarTimer(questions);
        //All cards background color set as white(Default color)
        cardA.setCardBackgroundColor(ContextCompat.getColor(this,R.color.white));
        cardB.setCardBackgroundColor(ContextCompat.getColor(this,R.color.white));
        cardC.setCardBackgroundColor(ContextCompat.getColor(this,R.color.white));
        cardD.setCardBackgroundColor(ContextCompat.getColor(this,R.color.white));
        //to increase size when prss nextButton
        size++;
        size=size%10;
        //todisply questions and its options
        questionBtn.setText(questions.get(size).getQuestion());
        optionA_Btn.setText(questions.get(size).getOptionA());
        optionB_Btn.setText(questions.get(size).getOptionB());
        optionC_Btn.setText(questions.get(size).getOptionC());
        optionD_Btn.setText(questions.get(size).getOptionD());
        //to check already select or not in options ---only one ans sholud be selected
        isItAlreadyPress=false;

    }
     boolean checkCorrectAns(List<Quiz> question,TextView textView){
        //to check pressed option is equal to its question ans
         if(textView.getText().equals(question.get(size).getQuestionAns())) return true;
         return false;
     }
    private  void QuizQuestions(List<Quiz>questions){
        //All question
        questions.add(new Quiz("Who Invented the 3-D printer?","Nick Holonyak","Elias Howe","Chuck Hull","Christiaan Huygens",
                "Chuck Hull"));
        questions.add(new Quiz("What is the maximum number of Members in Lok Sabha?","512","542","552","532","552"));
        questions.add(new Quiz("Which defence institution has been recently honoured with the President’s Colour?",
                "National Defence College","Indian Naval Academy","Counter Insurgency and Jungle Warfare School",
                "Officers Training Academy","Indian Naval Academy"));
        questions.add(new Quiz("Indian Army celebrated the Poonch Link-up Day on which date?","November 25","November 24",
                "November 23","November 21","November 23"));
        questions.add(new Quiz("Which is the first major defence ship to clear all sea acceptance trials in a single sea sortie?","ICGS Varad"," ICGS Vajra","ICGS Varaha","ICGS Veera","ICGS Varad"));
        questions.add(new Quiz("Which organisation has partnered with Indian Institute of Technology, Hyderabad to establish a research cell?","Indian Space Research Organisation","Defence Research and Development Organisation"
                ,"Hindustan Aeronautical Limited","Bharat Electronics Limited","Defence Research and Development Organisation"));
        questions.add(new Quiz("What is the smallest particle of an element that can exist independently and still retain the properties of the element",
                "Molecule","Atom","Electron","Proton","Atom"));
        questions.add(new Quiz("What is the process by which a solid changes directly into a gas without passing through a liquid phase called","Sublimation","Evaporation",
                "Condensation","Melting","Sublimation"));
        questions.add(new Quiz("Which of the following is a characteristic of a chemical change","A change in color",
                "A change in shape","A change in state","A change in size","A change in color"));
        questions.add(new Quiz("In which state living root bridges are found?","Assam",
                "Manipur","Odisha","Meghalaya","Meghalaya"));

        }


    private  void declarAll(){
        questionBtn= findViewById(R.id.questionId);
        optionA_Btn= findViewById(R.id.option_a_Id);
        optionB_Btn=findViewById(R.id.option_B_Id);
        optionC_Btn=findViewById(R.id.option_C_Id);
        optionD_Btn=findViewById(R.id.option_D_Id);
        showTotalTime=findViewById(R.id.totalQuizTimerId);

        cardA=findViewById(R.id.card_a_id);
        cardB=findViewById(R.id.card_b_id);
        cardC=findViewById(R.id.card_c_id);
        cardD=findViewById(R.id.card_d_id);
        nextBtn=findViewById(R.id.nextBtnId);
    }
    private  void horizProgressBarTimer(List<Quiz>question){
        if(countDownTimer1!=null)countDownTimer1.cancel();
        countDownTimer1= new CountDownTimer(10000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                int p=(int)millisUntilFinished/100;
                progressBar.setProgress(p);
            }

            @Override
            public void onFinish() {
                onTimeSelectOPtion=false;
                questionAndAnsDisplay(question);

            }
        };
       countDownTimer1.start();
    }
    private  void showTimerTotalQuiz(){
        new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int time=(int)millisUntilFinished/1000;
                showTotalTime.setText(time+"");
            }

            @Override
            public void onFinish() {
               startActivity(new Intent(MainActivity.this,DisplayScore.class));
            }
        }.start();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("TOTAL_SCORE_KEY",totalScore);
    }
}