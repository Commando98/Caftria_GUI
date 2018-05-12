/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication11;

import java.io.Serializable;
import java.util.Date;

public class Feedback implements Serializable {

    int FeedbackID;
    Customer FeedbackWriter;
    Date FeedbackDate;
    String FeedbackSubject;
    String FeedbackDetails;

}
