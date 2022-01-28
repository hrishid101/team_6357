package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Motor Test", group="Linear Opmode")
//@Disabled
public class Drive extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;
    private DcMotor carouselWheel;
    private DcMotor linearSlide;
    private DcMotor intakeWheel;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //Initialize Wheel Motors
//        leftFront  = hardwareMap.get(DcMotor.class, "frontLeft");
//        rightFront = hardwareMap.get(DcMotor.class, "frontRight");
//        leftBack  = hardwareMap.get(DcMotor.class, "backLeft");
//        rightBack = hardwareMap.get(DcMotor.class, "backRight");

        //Initialize General Use Motors
        carouselWheel  = hardwareMap.get(DcMotor.class, "carousel");
        linearSlide = hardwareMap.get(DcMotor.class, "slide");
        intakeWheel = hardwareMap.get(DcMotor.class, "intake");

        //Set wheel directions
//        leftFront.setDirection(DcMotor.Direction.FORWARD);
//        leftBack.setDirection(DcMotor.Direction.FORWARD);
//        rightFront.setDirection(DcMotor.Direction.REVERSE);
//        rightBack.setDirection(DcMotor.Direction.REVERSE);

        //Set motor directions
        carouselWheel.setDirection(DcMotor.Direction.REVERSE);
        linearSlide.setDirection(DcMotor.Direction.REVERSE);
        intakeWheel.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // LEFT STICK FORWARD BACKWARD
            // RIGHT STICK FOR TURNING
//            double drive = -gamepad1.right_stick_y;
//            double turn = gamepad1.left_stick_x;

            //R1 FOR CAROUSEL
            //DPAD UP/DOWN FOR LINEAR SLIDE
            //X FOR INTAKE WHEEL

            boolean spin = gamepad1.right_bumper;
            boolean dPadUp = gamepad1.dpad_up;
            boolean dPadDown = gamepad1.dpad_down;
            boolean xButton = gamepad1.x;

            // Send calculated power to wheels
//            leftFront.setPower(drive);
//            leftBack.setPower(drive);
//            rightFront.setPower(drive);
//            rightBack.setPower(drive);

//            if(turn > 0.0){
//                leftFront.setPower(1.0);
//                leftBack.setPower(1.0);
//                rightFront.setPower(-1.0);
//                rightBack.setPower(-1.0);
//            }
//            else if(turn < 0.0){
//                leftFront.setPower(-1.0);
//                leftBack.setPower(-1.0);
//                rightFront.setPower(1.0);
//                rightBack.setPower(1.0);
//            }

            //Setting power to Carousel Motor
            if(spin) {
                carouselWheel.setPower(1.0);
            }else {
                carouselWheel.setPower(0.0);
            }

            //Setting power to Linear Slide
            if(dPadUp) {
                linearSlide.setPower(1.0);
            }else {
                linearSlide.setPower(0.0);
            }
            if(dPadDown) {
                linearSlide.setPower(-1.0);
            }else {
                linearSlide.setPower(0.0);
            }

            //Setting power for Intake Wheel
            if(xButton) {
                intakeWheel.setPower(1.0);
            }else {
                intakeWheel.setPower(0.0);
            }



            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}