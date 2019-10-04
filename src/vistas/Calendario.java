package vistas;

import java.time.LocalDate;
import java.time.LocalTime;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Calendar.Style;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.view.CalendarView;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calendario extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {

            CalendarView calendarView = new CalendarView();

                Calendar birthdays = new Calendar("Turnos");

                birthdays.setStyle(Style.STYLE1);
                calendarView.setShowAddCalendarButton(false);
                calendarView.setShowDeveloperConsole(false);
                calendarView.setShowPageSwitcher(true);
                calendarView.setShowPageToolBarControls(true);
                calendarView.setShowPrintButton(false);
                calendarView.setShowSearchField(false);
                calendarView.setShowToolBar(true);
                calendarView.setShowSourceTrayButton(true);
                calendarView.getDayPage().getYearMonthView().setShowTodayButton(false);



                CalendarSource myCalendarSource = new CalendarSource("My Calendars");
                myCalendarSource.getCalendars().addAll(birthdays);

                calendarView.getCalendarSources().addAll(myCalendarSource);

                calendarView.setRequestedTime(LocalTime.now());

                Thread updateTimeThread = new Thread("Calendar: Update Time Thread") {
                        @Override
                        public void run() {
                                while (true) {
                                        Platform.runLater(() -> {
                                                calendarView.setToday(LocalDate.now());
                                                calendarView.setTime(LocalTime.now());
                                        });

                                        try {
                                                // update every 10 seconds
                                                sleep(10000);
                                        } catch (InterruptedException e) {
                                                e.printStackTrace();
                                        }

                                }
                        };
                };

                updateTimeThread.setPriority(Thread.MIN_PRIORITY);
                updateTimeThread.setDaemon(true);
                updateTimeThread.start();

                Scene scene = new Scene(calendarView);
                primaryStage.setTitle("Calendar");
                primaryStage.setScene(scene);
                primaryStage.setWidth(1300);
                primaryStage.setHeight(1000);
                primaryStage.centerOnScreen();
                primaryStage.show();
        }

        public static void main(String[] args) {
                launch(args);
        }
}