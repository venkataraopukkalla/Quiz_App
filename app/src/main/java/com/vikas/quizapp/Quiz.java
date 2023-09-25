package com.vikas.quizapp;

public class Quiz {
      private String question,optionA,optionB,optionC,optionD,questionAns;

      public Quiz(String question, String optionA, String optionB, String optionC, String optionD,String questionAns) {
            this.question = question;
            this.optionA = optionA;
            this.optionB = optionB;
            this.optionC = optionC;
            this.optionD = optionD;
            this.questionAns=questionAns;

      }

      public String getQuestion() {
            return question;
      }


      public String getOptionA() {
            return optionA;
      }


      public String getOptionB() {
            return optionB;
      }



      public String getOptionC() {
            return optionC;
      }


      public String getOptionD() {
            return optionD;
      }


      public String getQuestionAns() {
            return questionAns;
      }


}
