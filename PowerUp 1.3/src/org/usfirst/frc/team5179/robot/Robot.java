package org.usfirst.frc.team5179.robot;


import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
	public class Robot extends IterativeRobot {
	
	/** Variables non utilisees, par defaut dans le iterativerobot
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	*/
	
	/** Variables crees pour PowerUp 5179
	 * CD & SB 27 janvier 2018
	 */
	public RobotDrive myRobot = new RobotDrive(0,1,2,3);
	public Joystick Driver = new Joystick(0);
	public Joystick joystickLift = new Joystick (1);
	public JoystickButton BtnPinceOuvre = new JoystickButton(Driver, 1);
	public JoystickButton BtnPinceFerme = new JoystickButton(Driver, 2);
	public JoystickButton BtnBarrureFerme = new JoystickButton(Driver, 3);
	public JoystickButton BtnBarrureOuvre = new JoystickButton(Driver, 4);
	//public static AnalogInput Selecteur1 = new AnalogInput(0);
	//public static AnalogInput Selecteur2 = new AnalogInput(1);
	//public static AnalogInput Selecteur3 = new AnalogInput(2);
	//public static AnalogInput Selecteur4 = new AnalogInput(3);
	public AnalogInput LiftHaut = new AnalogInput(1);
	public AnalogInput LiftBas = new AnalogInput(0);
	public Boolean EtatPince;
	public Boolean EtatBarrure;
	public int ChoixAutonome = 0;
	public int EtatRobot;
	public int LoopCounter;
	public VictorSP MoteurLiftA = new VictorSP(4);
	public VictorSP MoteurLiftB = new VictorSP(5);
	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public static Solenoid PinceOuvre = new Solenoid(0,0);
	public static Solenoid PinceFerme = new Solenoid(0,1);
	public static int Debug;
	//public static Solenoid Barrure = new Solenoid(0,2);
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	public void Selecteur() {
		/*	if (Selecteur1.getVoltage() > 2) {
        	ChoixAutonome = 1;
        }
		else if (Selecteur2.getVoltage() > 2) {
        	ChoixAutonome = 2;
        }
		else if (Selecteur3.getVoltage() > 2) {
        	ChoixAutonome = 3;
        }
		else if (Selecteur4.getVoltage() > 2) {
        	ChoixAutonome = 4;
        }
		else {
        	ChoixAutonome = 0;
        }*/
	}
	
	
	@Override
	public void robotInit() {
		PinceOuvre.set(true);
		PinceFerme.set(false);
		EtatPince = true;
		//Barrure.set(false);
		EtatBarrure = false;
		/*chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto choices", chooser);*/
	}
	
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		PinceOuvre.set(true);
		PinceFerme.set(false);
		EtatPince = true;
		//Barrure.set(false);
		EtatBarrure = false;
		LoopCounter = 0;
		//autoSelected = chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		//System.out.println("Auto selected: " + autoSelected);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		switch (ChoixAutonome) {
			case 0:
				/**Code qui ne fait rien (par defaut)
				 * 
				 */
				break;
			case 1:
				/**qui avance le robot a la ligne
				 */
				LoopCounter++;
    			if (LoopCounter <= 250){
    		    		myRobot.drive(0.3, 0);
    		    	} else if (LoopCounter > 250){
    		    		myRobot.drive(0, 0);
    		    }
				break;
			case 2:
				/** Mettre un bloc dans la bascule
				 * Lever un peu les pinces
				 * Baisser les pinces
				 * Fermer les pinces
				 * Se tasser vers la gauche ou la droite (Dependamment de la variable)
				 * Lever les pinces a la hauteur de la bascule
				 * Avance pour etre coller sur la bascule
				 * Ouvre les pinces
				 * 
				 */
				break;
			case 3: 
				/** Mettre un bloc dans la balance
				 * 
				 */
				break;
			case 4: 
				/** Mettre un bloc dans la bascule et un autre bloc dans la balance
				 * 
				 */
				break;
		}
		/*switch (autoSelected) {
		case customAuto:
			// Put custom auto code here
			break;
		case defaultAuto:
		default:
			// Put default auto code here
			break;
		}*/
	}

	public void teleopInit() {
		/*This makes sure that the autonomous stops running when
		  teleop starts running. If you want the autonomous to 
		  continue until interrupted by another command, remove
		  this line or comment it out.
		  if (autonomousCommand != null) autonomousCommand.cancel();\
		*/
		PinceOuvre.set(true);
		PinceFerme.set(false);
		EtatPince = true;
		//Barrure.set(false);
		EtatBarrure = false;
	}
	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		//Utiliser seulement quand on a des roues normales
		//Enlever la ligne suivante quand nous aurons les roues mecanums
		//myRobot.arcadeDrive(Driver.getY(),(-Driver.getX())); 
		
		SmartDashboard.putNumber("LiftHaut",LiftHaut.getVoltage());
		SmartDashboard.putNumber("LiftBas",LiftBas.getVoltage());
		SmartDashboard.putBoolean("EtatPince", EtatPince);
		SmartDashboard.putBoolean("EtatBarrure", EtatBarrure);
		SmartDashboard.putNumber("EtatRobot",EtatRobot);
		SmartDashboard.putNumber("Joystick",joystickLift.getY());
		SmartDashboard.putBoolean("BtnPinceOuvre",BtnPinceOuvre.get());
		SmartDashboard.putBoolean("BtnPinceFerme",BtnPinceFerme.get());
		SmartDashboard.putNumber("Debug", Debug);
		
		myRobot.mecanumDrive_Cartesian(Driver.getX(), Driver.getY(), Driver.getZ(), 0);
		
		//Le bloc suivant sert a proteger le robot du lift s'il depasse les limites mecaniques
		if(LiftHaut.getVoltage() > 2 && LiftBas.getVoltage() > 2) {
			//Si le lift ne touche ni en haut ni en bas il peut lever ou descendre
			MoteurLiftA.set(joystickLift.getY());
			MoteurLiftB.set(joystickLift.getY());
			Debug = 1;
		}
		else if (LiftHaut.getVoltage() < 2 && LiftBas.getVoltage() > 2) {
			//Si le lift touche en haut mais ne touche pas en bas il peut descendre mais pas monter
			//Hypohese = getY est negatif quand je descends
			//Il peut y avoir une erreur si le driver baisse le joystick et que dans le 
			//20 milliseconde de la boucle il monte le joystick le lift peut quand meme monter.
			Debug = 2;
			if (joystickLift.getY() < 0) {
				MoteurLiftA.set(joystickLift.getY());
				MoteurLiftB.set(joystickLift.getY());
				Debug = 3;
				}
		}
		else if (LiftHaut.getVoltage() > 2 && LiftBas.getVoltage() < 2) {
			//Si le lift touche en bas mais ne touche pas en haut il peut monter mais pas descendre
			//Hypohese = getY est positif quand je monte
			//Il peut y avoir une erreur si le driver avance le joystick et que dans le 
			//20 milliseconde de la boucle il baisse le joystick le lift peut quand meme descendre.
			Debug = 4;
			if (joystickLift.getY() > 0) {
				MoteurLiftA.set(joystickLift.getY());
				MoteurLiftB.set(joystickLift.getY());
				Debug = 5;
				}
		}
		else if (LiftHaut.getVoltage() < 2 && LiftBas.getVoltage() < 2) {
			//Si le lift touche en bas et en haut (probleme), arrete le lift
			Debug = 6;
		}
		
		if(BtnPinceOuvre.get()) {
			EtatRobot = 1;
		}
		else if(BtnPinceFerme.get() && EtatPince == true && EtatBarrure == false) {
			EtatRobot = 2;
		}
		else if(BtnBarrureFerme.get() && EtatPince == true && EtatBarrure == false && LiftBas.getVoltage() > 2) {
			EtatRobot = 3;
		}
		else if(BtnBarrureOuvre.get() && EtatPince == true && EtatBarrure == true && LiftBas.getVoltage() > 2) {
			EtatRobot = 4;
		}
		
		
		switch (EtatRobot) {
			case 0:
				break;
				
			case 1: 
	        	//Ouvrir les pinces
				//Actionner la variable PinceOuvre (Solenoid)
				PinceOuvre.set(true);
				PinceFerme.set(false);
				EtatPince = true;
	        	break;
	
	        case 2:
	        	//Fermer les pinces
	        	//Actionner la variable PinceFerme (Solenoid)
	        	PinceFerme.set(false);
	        	PinceOuvre.set(true);
	        	EtatPince = false;
	        	break;
		  
	        case 3:
	        	//Barrer la barrure du lift
	        	//EtatBarrure = true
	        	//Actionner la variable Barrure (Solenoid)
	        	//Barrure.set(true);
	        	EtatBarrure = true;
	        	break;
	    	
	        case 4:
	        	//Debarrer la barrure du lift
	        	//EtatBarrure = false
	        	//Actionner la variable Barrure (Solenoid)
	        	//Barrure.set(false);
	        	EtatBarrure = false;
	        	break;
		}
	}	
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}

