package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Drive Test", group="Linear Opmode")
//@Disabled
public class MotorTest extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor carouselWheel;
    private DcMotor linearSlide;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //Initialize Motors
        //TODO NEED TO SET DEVICE NAME
        carouselWheel  = hardwareMap.get(DcMotor.class, "");
        linearSlide = hardwareMap.get(DcMotor.class, "");

        //Set motor directions
        carouselWheel.setDirection(DcMotor.Direction.FORWARD);
        linearSlide.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            //R1 button for spinning carousel wheel
            boolean spin = gamepad1.right_bumper;
            boolean dPadUp = gamepad1.dpad_up;
            boolean dPadDown = gamepad1.dpad_down;

            //Setting power to DC Motor
            if(spin) {
                carouselWheel.setPower(1.0);
            }else {
                carouselWheel.setPower(0.0);
            }
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

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}