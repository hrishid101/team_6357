package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="MecanumDriveTrain", group="Linear Opmode")
//@Disabled
public class Drive extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //Initialize Wheel Motors
        leftFront  = hardwareMap.get(DcMotor.class, "frontLeft");
        rightFront = hardwareMap.get(DcMotor.class, "frontRight");
        leftBack  = hardwareMap.get(DcMotor.class, "backLeft");
        rightBack = hardwareMap.get(DcMotor.class, "backRight");


        //Set wheel directions
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // LEFT STICK FORWARD BACKWARD
            // RIGHT STICK FOR TURNING
            double drive = -gamepad2.right_stick_y;
            double strafe = gamepad2.right_stick_x;
            double turn = gamepad2.left_stick_x;

            // Send calculated power to wheels
            leftFront.setPower(drive);
            leftBack.setPower(drive);
            rightFront.setPower(drive);
            rightBack.setPower(drive);

            //Strafe right
            if(strafe > 0.0){
                leftFront.setPower(0.75);
                leftBack.setPower(-0.75);
                rightFront.setPower(-0.75);
                rightBack.setPower(0.75);
            }
            //Strafe left
            else if(strafe < 0.0){
                leftFront.setPower(-0.75);
                leftBack.setPower(0.75);
                rightFront.setPower(0.75);
                rightBack.setPower(-0.75);
            }

            //Turn left
            if(turn < 0.0){
                leftFront.setPower(-0.75);
                leftBack.setPower(-0.75);
                rightFront.setPower(0.75);
                rightBack.setPower(0.75);
            }
            //Turn right
            else if(turn > 0.0){
                leftFront.setPower(0.75);
                leftBack.setPower(0.75);
                rightFront.setPower(-0.75);
                rightBack.setPower(-0.75);
            }

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}

