package Hospital_Management;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.*;

class Doctor {
    int doc_id;
    String doc_name;
    String speciality;
    String qualification;
    String availability;

    Scanner sc = new Scanner(System.in);

    public void setDocInfo() {


        System.out.println("Enter Doctor Name:");
        doc_name = sc.nextLine();
        System.out.println("What is your speciality:");
        speciality = sc.nextLine();
        System.out.println("What is your qualification:");
        qualification = sc.nextLine();
        System.out.println("Are you available( 1.Yes    2.No ):");
        int x=sc.nextInt();
        if (x==1)
        {
            availability = "yes";
            System.out.println("Yes");
        } else if (x==2) {
            availability = "No";
            System.out.println("No");
        }else {
            System.out.println("wrong Input");
        }
    }

    public void diplDocInfo() {
        System.out.println("__________________________________________________________________________________");
        System.out.println("\t\t\t\t\t\tDoctor " + doc_name + " Information");
        System.out.println("__________________________________________________________________________________");
        System.out.println("ID No.              : " + doc_id);
        System.out.println("Doctor Name         : " + doc_name);
        System.out.println("Doctor Speciality   : " + speciality);
        System.out.println("Doctor's Qualification: " + qualification);
        System.out.println("Available           : " + availability);
        System.out.println();

    }
}

class Patient {
    int pat_id;
    String pat_name;
    int pat_age;
    String pat_gen;
    String disease;
    String admit;
    String contact;

    public void setPatInfo()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Patient Name:");
        pat_name= sc.nextLine();

//        System.out.println("What is your Age:");
//        pat_age = sc.nextInt();
//
//        System.out.println("What is your gender(1.Male 2.Female):");
//
//        int x= sc.nextInt();
//        if (x==1)
//        {
//            pat_gen = "Male";
//            System.out.println("Male");
//        }else if(x==2){
//            pat_gen = "Female";
//            System.out.println("Female");
//        }else {
//            System.out.println("Wrong Input");
//        }
//
//        System.out.println("What is your contact No.:");
//        contact = sc.next();
//
//        System.out.println("What is your disease:");
//        disease = sc.next();
//
//        System.out.println("Are you want to admit( 1.Yes  2.No):");
//        x= sc.nextInt();
//        if (x==1)
//        {
//            admit = "Yes";
//            System.out.println("Yes");
//        }else if(x==2){
//            admit = "No";
//            System.out.println("No");
//        }else {
//            System.out.println("Wrong Input");
//        }

    }

    public void diplPatInfo()
    {
        System.out.println("__________________________________________________________________________________");
        System.out.println("\t\t\t\t\t\tPatient's Information");
        System.out.println("__________________________________________________________________________________");
        System.out.println("Patient ID            : " + pat_id);
        System.out.println("Patient Name          : " + pat_name);
        System.out.println("Patient age           : " + pat_age);
        System.out.println("Patient Gender        : " + pat_gen);
        System.out.println("Patient's Contact No. : " + contact);
        System.out.println("Patient's disease     : " + disease);
        System.out.println("Patient is admitted?  : " + admit);
    }
}

class Staff {
    int sat_id;
    String sat_name;
    int sat_age;
    String sat_gen;
    String qual;
    String designation;
    String contact;

    public void setSatInfo()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Staff Name:");
        sat_name= sc.nextLine();

        System.out.println("What is your Age:");
        sat_age = sc.nextInt();

        System.out.println("What is your gender( 1.Male   2.Female):");

        int x= sc.nextInt();
        if (x==1)
        {
            sat_gen = "Male";
            System.out.println("Male");
        }else if(x==2){
            sat_gen = "Female";
            System.out.println("Female");
        }else {
            System.out.println("Wrong Input");
        }

        System.out.println("What is your contact No.:");
        contact = sc.next();

        System.out.println("What is your Qualification:");
        qual = sc.next();

        sc.nextLine();
        System.out.println("Designation");
        designation = sc.next();


    }

    public void diplSatInfo()
    {
        System.out.println("__________________________________________________________________________________");
        System.out.println("\t\t\t\t\t\tStaff's Information");
        System.out.println("__________________________________________________________________________________");
        System.out.println("Staff ID      : " + sat_id);
        System.out.println("Name          : " + sat_name);
        System.out.println("age           : " + sat_age);
        System.out.println("Gender        : " + sat_gen);
        System.out.println("Contact No.   : " + contact);
        System.out.println("Qualification : " + qual);
        System.out.println("Designation  : " + designation);
    }
}

class Display {
    public void listOfDoctor(int count, Doctor[] doc)
    {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < count; i++)
        {
            System.out.println(doc[i].doc_id + ": " + doc[i].doc_name);
        }

        System.out.println("Do want to see full detail of doctor? 1.Yes    2.Doctor Section");
        int num3 = sc.nextInt();

        if (num3 == 1)
        {

            do
            {
                System.out.println("Which doctor information want to see? Enter serial no.:");
                num3 = sc.nextInt();
                doc[num3-1].diplDocInfo();
                System.out.println("Information Of Other Doctor: 1.Yes     2.Doctor Section");
                num3 = sc.nextInt();
            } while (num3 == 1);

        }
    }

    public void listOfPatient(int count, Patient[] pat)
    {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < count; i++)
        {
            System.out.println(pat[i].pat_id + ": " + pat[i].pat_name);
        }

        System.out.println("Do you want to see full detail of patient? 1.Yes    2.Patient Section");
        int num3 = sc.nextInt();

        if (num3 == 1)
        {

            do
            {
                System.out.println("Which doctor information want to see? Enter serial no.:");
                num3 = sc.nextInt();
                pat[num3-1].diplPatInfo();
                System.out.println("Information Of Other Doctor: 1.Yes   2.Patient Section");
                num3 = sc.nextInt();
            } while (num3 == 1);

        }
    }

    public void listOfStaff(int count,Staff[] stf)
    {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < count; i++)
        {
            System.out.println(stf[i].sat_id + ": " + stf[i].sat_name);
        }

        System.out.println("Do want to see full detail of Staff? 1.Yes    2.Staff Section");
        int num3 = sc.nextInt();

        if (num3 == 1)
        {

            do
            {
                System.out.println("Which staff information want to see? Enter serial no.:");
                num3 = sc.nextInt();
                stf[num3-1].diplSatInfo();
                System.out.println("Information Of Other staff: 1.Yes    2.Staff Section");
                num3 = sc.nextInt();
            } while (num3 == 1);

        }
    }

}

class Appointment
{
    int dId;
    String dName;
    String dSpeciality;
    String dQualification;
    String dAvailability;

    int pId;
    String pName;
    int pAge;
    String pGen;
    String pDisease;
    String pAdmit;
    String pContact;

    LocalDate date;

    public void appoint(int sp,int sd,Patient[] pat,Doctor[] doc,int day,int month)
    {
        pId = pat[sp].pat_id;
        pName = pat[sp].pat_name;
        pAge = pat[sp].pat_age;
        pGen = pat[sp].pat_gen;
        pContact = pat[sp].contact;
        pDisease = pat[sp].disease;
        pAdmit = pat[sp].admit="Yes";

        dId = doc[sd].doc_id;
        dName = doc[sd].doc_name;
        dSpeciality = doc[sd].speciality;
        dQualification = doc[sd].qualification;
        dAvailability = doc[sd].availability="Yes";
        date = LocalDate.of(2023,month,day);
    }

    public void displAppoint()
    {
        System.out.println("__________________________________________________________________________________");
        System.out.println("\t\t\t\t\t\t\tAppointment Detail");
        System.out.println("__________________________________________________________________________________");

        System.out.println("Patient ID            : " + pId);
        System.out.println("Patient Name          : " + pName);
        System.out.println("Patient age           : " + pAge);
        System.out.println("Patient Gender        : " + pGen);
        System.out.println("Patient's Contact No. : " + pContact);
        System.out.println("Patient's disease     : " + pDisease);
        System.out.println("Patient is admitted?  : " + pAdmit);
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("ID No.                : " + dId);
        System.out.println("Doctor Name           : " + dName);
        System.out.println("Doctor Speciality     : " + dSpeciality);
        System.out.println("Doctor's Qualification: " + dQualification);
        System.out.println("Available             : " + dAvailability);
        System.out.println("Meeting Date          : " + date);

    }

}


public class HospitalManagement {
    public static void main(String[] args) {
        
        System.out.println("__________________________________________________________________________________");
        System.out.println("\t\t\t\tWELCOME PW HOSPITAL");
        System.out.println("__________________________________________________________________________________");

        Scanner sc = new Scanner(System.in);

        Doctor[] doc = new Doctor[50];
        Patient[] pat = new Patient[100];
        Appointment[] ap = new Appointment[50];
        Staff[] stf = new Staff[50];

        Display display = new Display();

        int v1,v2=0,v3=0,sw=1,t=0,l=0,h=0,n=0;



        while (sw==1)
        {
            System.out.println("__________________________________________________________________________________");
            System.out.println("\t1.Doctor   2.Patient   3.Staff   4.Appointment   5.Close the program");
            System.out.println("__________________________________________________________________________________");

            v1 = sc.nextInt();
            switch (v1)
            {
                case 1-> //Doctor
                {
                    System.out.println("1.Register    2.List Of Doctors      3.Main menu");
                    try
                    {
                        v2 = sc.nextInt();
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("Wrong Input, Enter Correct value:");
                    }

                    do {
                        switch (v2)
                        {
                            case 1-> // Registration
                            {
                                doc[t] = new Doctor();
                                doc[t].setDocInfo();
                                doc[t].doc_id=t+1;
                                t++;
                            }
                            case 2-> //List
                            {
                                display.listOfDoctor(t,doc);
                            }
                            case 3->
                            {
                                continue;
                            }
                            default ->
                            {
                                System.out.println("Wrong input");
                            }
                        }
                        System.out.println("1.Register again    2.List of Doctor    3.Main menu");
                        try
                        {
                            v3 = sc.nextInt();
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Wrong Input");
                        }
                        v2=v3;
                    }while (v3==1 || v3==2);
                }

                case 2-> //Patient
                {
                    System.out.println("1.Register    2.List Of Patient    3.Main menu");
                    try
                    {
                        v2 = sc.nextInt();
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("Wrong Input, Enter Correct value:");
                    }

                    do {
                        switch (v2)
                        {
                            case 1-> // Registration
                            {
                                pat[l] = new Patient();
                                pat[l].setPatInfo();
                                pat[l].pat_id=l+1;
                                l++;
                            }
                            case 2-> //List
                            {
                                display.listOfPatient(l,pat);
                            }
                            case 3->
                            {
                                continue;
                            }
                            default ->
                            {
                                System.out.println("Wrong input");
                            }
                        }
                        System.out.println("1.Register again    2.List of Patient    3.Main menu");
                        try
                        {
                            v3 = sc.nextInt();
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Wrong Input");
                        }
                        v2=v3;
                    }while (v3==1 || v3==2);
                }

                case 3-> //Staff
                {
                    System.out.println("1.Register    2.List Of Staff    3.Main menu");
                    try
                    {
                        v2 = sc.nextInt();
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("Wrong Input, Enter Correct value:");
                    }

                    do {
                        switch (v2)
                        {
                            case 1-> // Registration
                            {
                                stf[n] = new Staff();
                                stf[n].setSatInfo();
                                stf[n].sat_id=n+1;
                                n++;
                            }
                            case 2-> //List
                            {
                                display.listOfStaff(n,stf);
                            }
                            case 3->
                            {
                                continue;
                            }
                            default ->
                            {
                                System.out.println("Wrong input");
                            }
                        }
                        System.out.println("1.Register again    2.List of Staff     3.Main menu");
                        try
                        {
                            v3 = sc.nextInt();
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Wrong Input");
                        }
                        v2=v3;
                    }while (v3==1 || v3==2);

                }

                case 4-> //Appointment
                {
                    System.out.println("1.Register an appointment     2.List of appointment");
                    v2 = sc.nextInt();
                    switch (v2)
                    {
                        case 1->
                        {
                            System.out.println("1.Registered Patient    2.New Patient");
                            v2 = sc.nextInt();
                            switch (v2)
                            {
                                case 1->
                                {
                                    do {
                                    System.out.println("Select patient:");
                                    for (int i=0;i<l;i++)
                                    {
                                        System.out.println(pat[i].pat_id+". "+pat[i].pat_name);
                                    }

                                    int sl = sc.nextInt();
                                    sl=sl-1;

                                    System.out.println("\nSelect Doctor:");
                                    for (int i=0;i<t;i++)
                                    {
                                        System.out.println(doc[i].doc_id+". "+doc[i].doc_name);
                                    }

                                    int sd = sc.nextInt();
                                    sd=sd-1;

                                        int check=0;
                                        for (int i=0;i<h;i++)
                                        {
                                            if ( ap[i].pId==pat[sl].pat_id)
                                            {
                                                System.out.println("This patient is already registered for an appointment, select other.");
                                                System.out.println("\n1.Register  2.Main Menu");
                                                check = sc.nextInt();
                                            }
                                        }

                                        if (check==1) {
                                            continue;
                                        }
                                        else if (check>1) {
                                            break;
                                        }



                                        sc.nextLine();
                                        System.out.println("Enter Date(Ex - 1-31)");
                                        int dd = sc.nextInt();
                                        System.out.println("Enter Month(Ex - 1-12)");
                                        int mm = sc.nextInt();

                                        ap[h] = new Appointment();
                                        ap[h].appoint(sl,sd,pat,doc,dd,mm);
                                        ap[h].displAppoint();
                                        h++;

                                        System.out.println("\n1.Reg app. again     2.Main menu");
                                        v3=sc.nextInt();

                                    }while (v3==1);

                                }
                                case 2->
                                {
                                    System.out.println("First of all register yourself");
                                }
                            }
                        }
                        case 2->
                        {
                            for (int i=0;i<h;i++)
                            {
                                System.out.println((i+1)+". ID-"+ap[i].pId+" "+ap[i].pName+" has an appointment with Dr. "+ap[i].dName+" on "+ap[i].date);
                            }
                        }
                        default ->
                        {
                            System.out.println("Wrong input");
                        }
                    }
                }

            } // switch

            if (v1==5)
            {
                System.out.println("1.Exit    2.Cancel");
                v1= sc.nextInt();;
                if (v1==1)
                {
                    sw=-1;
                }
            }
        }//while

    }
}


