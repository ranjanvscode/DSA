
import java.util.InputMismatchException;
import java.util.LinkedList;
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
            System.out.println("wrong Input!");
        }
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

        System.out.println("What is your Age:");
        pat_age = sc.nextInt();

        System.out.println("What is your gender(1.Male 2.Female):");

        int x= sc.nextInt();
        if (x==1)
        {
            pat_gen = "Male";
            System.out.println("Male");
        }else if(x==2){
            pat_gen = "Female";
            System.out.println("Female");
        }else {
            System.out.println("Wrong Input!");
        }

        System.out.println("What is your contact No.:");
        contact = sc.next();

        System.out.println("What is your disease:");
        disease = sc.next();

        System.out.println("Are you want to admit( 1.Yes  2.No):");
        x= sc.nextInt();
        if (x==1)
        {
            admit = "Yes";
            System.out.println("Yes");
        }else if(x==2){
            admit = "No";
            System.out.println("No");
        }else {
            System.out.println("Wrong Input!");
        }

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
            System.out.println("Wrong Input!");
        }

        System.out.println("What is your contact No.:");
        contact = sc.next();

        System.out.println("What is your Qualification:");
        qual = sc.next();

        sc.nextLine();
        System.out.println("Designation");
        designation = sc.next();


    }

}

class Display {
    public void listOfDoctor(LinkedList<Doctor> docList)
    {

        Scanner sc = new Scanner(System.in);

        for (Doctor docT:docList)
        {
            System.out.println(docT.doc_id+". "+docT.doc_name);
        }

        System.out.println("\nDo want to see full detail of doctor? 1.Yes    2.Doctor Section");
        int num3 = sc.nextInt();

        if (num3 == 1)
        {

            do
            {
                System.out.println("Which doctor information want to see? Enter serial no.:");
                num3 = sc.nextInt();


                if(num3>docList.size())
                {
                    System.out.println("Wrong input!");
                    continue;
                }
                else {
                    System.out.println("__________________________________________________________________________________");
                    System.out.println("\t\t\t\t\t\tDoctor " + docList.get(num3 - 1).doc_name + " Information");
                    System.out.println("__________________________________________________________________________________");
                    System.out.println("ID No.              : " + docList.get(num3 - 1).doc_id);
                    System.out.println("Doctor Name         : " + docList.get(num3 - 1).doc_name);
                    System.out.println("Doctor Speciality   : " + docList.get(num3 - 1).speciality);
                    System.out.println("Doctor's Qual       : " + docList.get(num3 - 1).qualification);
                    System.out.println("Available           : " + docList.get(num3 - 1).availability);
                }

                System.out.println("\nInformation Of Other Doctor: 1.Yes     2.Doctor Section");
                num3 = sc.nextInt();
            } while (num3 == 1);

        }
    }

    public void listOfPatient(LinkedList<Patient> patList)
    {

        Scanner sc = new Scanner(System.in);

        for (Patient patT:patList)
        {
            System.out.println(patT.pat_id+". "+patT.pat_name);
        }

        System.out.println("\nDo you want to see full detail of patient? 1.Yes    2.Patient Section");
        int num3 = sc.nextInt();

        if (num3 == 1)
        {

            do
            {
                System.out.println("Which doctor information want to see? Enter serial no.:");
                num3 = sc.nextInt();

                if(num3>patList.size())
                {
                    System.out.println("Wrong input!");
                    continue;
                }
                else
                {
                    System.out.println("__________________________________________________________________________________");
                    System.out.println("\t\t\t\t\t\tPatient's Information");
                    System.out.println("__________________________________________________________________________________");
                    System.out.println("Patient ID            : " + patList.get(num3-1).pat_id);
                    System.out.println("Patient Name          : " + patList.get(num3-1).pat_name);
                    System.out.println("Patient age           : " + patList.get(num3-1).pat_age);
                    System.out.println("Patient Gender        : " + patList.get(num3-1).pat_gen);
                    System.out.println("Patient's Contact No. : " + patList.get(num3-1).contact);
                    System.out.println("Patient's disease     : " + patList.get(num3-1).disease);
                    System.out.println("Patient is admitted?  : " + patList.get(num3-1).admit);
                }


                System.out.println("\nInformation Of Other Patient: 1.Yes   2.Patient Section");
                num3 = sc.nextInt();
            } while (num3 == 1);

        }
    }

    public void listOfStaff(LinkedList<Staff> stfList)
    {
        Scanner sc = new Scanner(System.in);

        for (Staff stfT:stfList)
        {
            System.out.println(stfT.sat_id + ": " + stfT.sat_name);
        }

        System.out.println("\nDo want to see full detail of Staff? 1.Yes    2.Staff Section");
        int num3 = sc.nextInt();

        if (num3 == 1)
        {

            do
            {
                System.out.println("Which staff information want to see? Enter serial no.:");
                num3 = sc.nextInt();


                if(num3>stfList.size())
                {
                    System.out.println("Wrong input!");
                    continue;
                }
                else
                {
                    System.out.println("__________________________________________________________________________________");
                    System.out.println("\t\t\t\t\t\tStaff's Information");
                    System.out.println("__________________________________________________________________________________");
                    System.out.println("Staff ID      : " + stfList.get(num3-1).sat_id);
                    System.out.println("Name          : " + stfList.get(num3-1).sat_name);
                    System.out.println("age           : " + stfList.get(num3-1).sat_age);
                    System.out.println("Gender        : " + stfList.get(num3-1).sat_gen);
                    System.out.println("Contact No.   : " + stfList.get(num3-1).contact);
                    System.out.println("Qualification : " + stfList.get(num3-1).qual);
                    System.out.println("Designation   : " + stfList.get(num3-1).designation);
                }

                System.out.println("\nInformation Of Other staff: 1.Yes    2.Staff Section");
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

    public void appoint(int sp,int sd,LinkedList<Patient> pat,LinkedList<Doctor> doc,int day,int month)
    {
        pId = pat.get(sp).pat_id;
        pName = pat.get(sp).pat_name;
        pAge = pat.get(sp).pat_age;
        pGen = pat.get(sp).pat_gen;
        pContact = pat.get(sp).contact;
        pDisease = pat.get(sp).disease;
        pAdmit = pat.get(sp).admit="Yes";

        dId = doc.get(sd).doc_id;
        dName = doc.get(sd).doc_name;
        dSpeciality = doc.get(sd).speciality;
        dQualification = doc.get(sd).qualification;
        dAvailability = doc.get(sd).availability="Yes";
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


public class HospitalTest {
    public static void main(String[] args) {

        System.out.println("__________________________________________________________________________________");
        System.out.println("\t\t\t\t\t\tWELCOME PW HOSPITAL");
        System.out.println("__________________________________________________________________________________");

        Scanner sc = new Scanner(System.in);

        LinkedList<Doctor> docList = new LinkedList<>();
        LinkedList<Patient> patList = new LinkedList<>();
        LinkedList<Staff> stfList = new LinkedList<>();
        LinkedList<Appointment> appList = new LinkedList<>();

        Display display = new Display();

        int v1,v2=0,v3=0,sw=1,t=1,l=1,n=1;

        while (sw==1)
        {
            System.out.println("__________________________________________________________________________________");
            System.out.println("\t\t1.Doctor   2.Patient   3.Staff   4.Appointment   5.Close the program");
            System.out.println("__________________________________________________________________________________");

            v1 = sc.nextInt();
            switch (v1)
            {
                case 1-> //Doctor
                {
                    System.out.println("************************************ Doctor Section **********************************");
                    System.out.println("1.Register    2.List Of Doctors      3.Update Doc Info    4.Delete Doctor   5.Main menu");
                    try
                    {
                        v2 = sc.nextInt();
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("Wrong Input!\nEnter Correct value:");
                    }

                    do {
                        switch (v2)
                        {
                            case 1-> // Registration
                            {
                                Doctor doc = new Doctor();
                                doc.setDocInfo();
                                doc.doc_id=t;
                                docList.add(doc);
                                t++;
                            }
                            case 2-> //List
                            {
                                if(docList.isEmpty())
                                {
                                    System.out.println("No doctors have registered yet.");
                                }else {
                                    display.listOfDoctor(docList);
                                }
                            }
                            case 3-> // Update func
                            {
                                if(docList.isEmpty())
                                {
                                    System.out.println("No doctors have registered yet.");
                                    v3=5;
                                    continue;
                                }else {
                                    for (Doctor docT:docList)
                                    {
                                        System.out.println(docT.doc_id+". "+docT.doc_name);
                                    }
                                }

                                System.out.println("\nWhich doctor info do you want to update?");

                                int sr=sc.nextInt();
                                System.out.println("what do you want to update:  1.Name  2.Speciality  3.Qualification  4.Availability");
                                int up = sc.nextInt();
                                switch (up)
                                {
                                    case 1->
                                    {
                                        System.out.println("Enter Name:");
                                        sc.nextLine();
                                        docList.get(sr-1).doc_name = sc.nextLine();
                                    }
                                    case 2->
                                    {
                                        System.out.println("Enter Speciality:");
                                        sc.nextLine();
                                        docList.get(sr-1).speciality = sc.nextLine();
                                    }
                                    case 3->
                                    {
                                        System.out.println("Enter Qualification:");
                                        sc.nextLine();
                                        docList.get(sr-1).qualification = sc.nextLine();
                                    }
                                    case 4->
                                    {
                                        System.out.println("Available: 1.Yes  2.No");
                                        up = sc.nextInt();
                                        if (up==1)
                                        {
                                            docList.get(sr-1).availability = "yes";
                                            System.out.println("Yes");
                                        } else if (up==2) {
                                            docList.get(sr-1).availability = "No";
                                            System.out.println("No");
                                        }else {
                                            System.out.println("wrong Input!");
                                        }

                                    }

                                    default -> System.out.println("Wrong input!");
                                }

                            }
                            case 4-> // Delete func
                            {
                                if(docList.isEmpty())
                                {
                                    System.out.println("No doctors have registered yet.");
                                    v3=5;
                                    continue;
                                }else {
                                    for (Doctor docT:docList)
                                    {
                                        System.out.println(docT.doc_id+". "+docT.doc_name);
                                    }
                                }

                                System.out.println("\nWhich doctor info do you want to delete?");

                                int sr=sc.nextInt();
                                docList.remove(sr-1);
                            }
                            case 5->
                            {
                                continue;
                            }
                            default -> System.out.println("Wrong input!");
                        }

                        System.out.println("\n1.Register    2.List Of Doctors      3.Update Doc Info    4.Delete Doctor   5.Main menu");

                        try
                        {
                            v3 = sc.nextInt();
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Wrong Input!");
                        }
                        v2=v3;

                    }while (v3>=1 && v3<5);
                }

                case 2-> //Patient
                {
                    System.out.println("************************************ Patient Section ***********************************");
                    System.out.println("\n1.Register    2.List Of Patient    3.Update patient    4.Delete patient    5.Main menu");
                    try
                    {
                        v2 = sc.nextInt();
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("Wrong Input!\nEnter Correct value:");
                    }

                    do {
                        switch (v2)
                        {
                            case 1-> // Registration
                            {
                                Patient pat = new Patient();
                                pat.setPatInfo();
                                pat.pat_id=l;
                                patList.add(pat);
                                l++;
                            }
                            case 2-> //List
                            {
                                if(patList.isEmpty())
                                {
                                    System.out.println("No patients have registered yet.");
                                }else {
                                    display.listOfPatient(patList);
                                }
                            }

                            case 3-> // Update func
                            {
                                if(patList.isEmpty())
                                {
                                    System.out.println("No patients have registered yet.");
                                    v3=5;
                                    continue;
                                }else {
                                    for (Patient patT:patList)
                                    {
                                        System.out.println(patT.pat_id+". "+patT.pat_name);
                                    }
                                }

                                System.out.println("\nWhich patient info do you want to update?");

                                int sr=sc.nextInt();
                                System.out.println("what do you want to update:  1.Name  2.Age  3.Gen  4.Disease  5.Contact No.");
                                int up = sc.nextInt();
                                switch (up)
                                {
                                    case 1->
                                    {
                                        System.out.println("Enter Name:");
                                        sc.nextLine();
                                        patList.get(sr-1).pat_name = sc.nextLine();
                                    }
                                    case 2->
                                    {
                                        System.out.println("Enter Age:");
                                        patList.get(sr-1).pat_age = sc.nextInt();
                                    }
                                    case 3->
                                    {
                                        System.out.println("Enter Gen: 1.Male  2.Female");
                                        up = sc.nextInt();
                                        if (up==1)
                                        {
                                            patList.get(sr-1).pat_gen = "Male";
                                        }
                                        else {
                                            patList.get(sr-1).pat_gen = "Female";
                                        }
                                    }
                                    case 4->
                                    {
                                        System.out.println("Enter disease name:");
                                        patList.get(sr-1).disease = sc.nextLine();
                                    }
                                    case 5->
                                    {
                                        System.out.println("Enter contact No.:");
                                        patList.get(sr-1).contact = sc.nextLine();
                                    }
                                    default -> System.out.println("Wrong input!");
                                }

                            }
                            case 4-> // Delete func
                            {
                                if(patList.isEmpty())
                                {
                                    System.out.println("No patients have registered yet.");
                                    v3=5;
                                    continue;
                                }else {
                                    for (Patient patT:patList)
                                    {
                                        System.out.println(patT.pat_id+". "+patT.pat_name);
                                    }
                                }

                                System.out.println("\nWhich patient info do you want to delete?");

                                int sr=sc.nextInt();
                                patList.remove(sr-1);
                            }
                            case 5->
                            {
                                continue;
                            }
                            default -> System.out.println("Wrong input!");
                        }
                        System.out.println("\n1.Register    2.List of Patient    3.Update patient    4.Delete patient    5.Main menu");
                        try
                        {
                            v3 = sc.nextInt();
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Wrong Input!");
                        }
                        v2=v3;
                    }while (v3>=1 && v3<5);
                }

                case 3-> //Staff
                {
                    System.out.println("*********************** Staff Section ***********************");
                    System.out.println("1.Register    2.List Of Staff    3.Delete Staff   4.Main menu");
                    try
                    {
                        v2 = sc.nextInt();
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("Wrong Input!\nEnter Correct value:");
                    }

                    do {
                        switch (v2)
                        {
                            case 1-> // Registration
                            {
                                Staff stf = new Staff();
                                stf.setSatInfo();
                                stf.sat_id=n;
                                stfList.add(stf);
                                n++;
                            }
                            case 2->
                            {
                                if(stfList.isEmpty())
                                {
                                    System.out.println("No staffs have registered yet.");
                                }else {
                                    display.listOfStaff(stfList);
                                }

                            }

                            case 3->
                            {
                                if(stfList.isEmpty())
                                {
                                    System.out.println("No staff have registered yet.");
                                    v3=5;
                                    continue;
                                }else {
                                    for (Staff stfT:stfList)
                                    {
                                        System.out.println(stfT.sat_id+". "+stfT.sat_name);
                                    }
                                }

                                System.out.println("\nWhich staff info do you want to delete?");

                                int sr=sc.nextInt();
                                stfList.remove(sr-1);
                            }
                            case 4 ->
                            {
                                continue;
                            }

                            default -> System.out.println("Wrong input!");
                        }
                        System.out.println("\n1.Register    2.List of Staff     3.Delete Staff   4.Main menu");
                        try
                        {
                            v3 = sc.nextInt();
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Wrong Input!");
                        }
                        v2=v3;
                    }while (v3>=1 && v3<4);

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
                                        for (Patient patT:patList)
                                        {
                                            System.out.println(patT.pat_id+". "+patT.pat_name);
                                        }

                                        int sl = sc.nextInt();
                                        sl=sl-1;

                                        System.out.println("\nSelect Doctor:");
                                        for (Doctor docT:docList)
                                        {
                                            System.out.println(docT.doc_id+". "+docT.doc_name);
                                        }

                                        int sd = sc.nextInt();
                                        sd=sd-1;

                                        int check=0; // Here Checking that Patient is already registered or not.
                                        for (Appointment appT:appList)
                                        {
                                            if ( appT.pId==patList.get(sl).pat_id)
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

                                        sc.nextLine(); // Taking input of date.
                                        System.out.println("Enter Date(Ex - 1-31)");
                                        int dd = sc.nextInt();
                                        System.out.println("Enter Month(Ex - 1-12)");
                                        int mm = sc.nextInt();

                                        Appointment app = new Appointment(); // Creating appointment data list
                                        app.appoint(sl,sd,patList,docList,dd,mm);
                                        appList.add(app);
                                        app.displAppoint();

                                        System.out.println("\n1.Reg apt     2.Main menu");
                                        v3=sc.nextInt();

                                    }while (v3==1);

                                }
                                case 2-> System.out.println("First of all register yourself");
                            }
                        }
                        case 2->
                        {
                            int h=1;
                            if (appList.isEmpty())
                            {
                                System.out.println("No patient have taken appointment yet.");
                            }
                            for (Appointment appT:appList)
                            {
                                System.out.println((h +". ID-"+appT.pId+" "+appT.pName+" has an appointment with Dr. "+appT.dName+" on "+appT.date));
                                h++;
                            }
                        }
                        default -> System.out.println("Wrong input!");
                    }
                }

            } // switch

            if (v1==5)
            {
                System.out.println("1.Exit    2.Cancel");
                v1= sc.nextInt();
                if (v1==1)
                {
                    sw=-1;
                }
            }
        }//while
    }
}