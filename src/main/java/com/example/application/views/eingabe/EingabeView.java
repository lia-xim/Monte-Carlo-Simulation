package com.example.application.views.eingabe;

import com.example.application.data.entity.SamplePerson;
import com.example.application.data.service.SamplePersonService;
import com.example.application.views.MainLayout;
import com.example.application.views.dashboard.DashboardView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Eingabe")
@Route(value = "Eingabe", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class EingabeView extends Div {

    private IntegerField startingYear = new IntegerField("Start Jahr");
    private IntegerField endingYear = new IntegerField("End Jahr");
    private IntegerField yearlyDeposit = new IntegerField("Jährliche Einzahlung");
    private IntegerField yearlyWidthdraw = new IntegerField("Jährliche Auszahlung");
    private IntegerField instances = new IntegerField("Instanzen");
    private IntegerField startingCapital = new IntegerField("Start Kapital");
    private IntegerField inflationRate = new IntegerField("Inflationsrate");
    private IntegerField yieldRate = new IntegerField("Rendite");
    private IntegerField standardDeviation = new IntegerField("Standardabweichung");
    private ComboBox strategy = new ComboBox("Strategie");

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private Binder<SamplePerson> binder = new Binder<>(SamplePerson.class);

    public EingabeView(SamplePersonService personService) {
        addClassName("eingabe-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        clearForm();

        setupInputFields();

        cancel.addClickListener(e -> clearForm());
        save.addClickListener(e -> {
            checkInputData();
        });
    }

    private void checkInputData() {
        Boolean inputIsValid = true;
        if (!startingYear.isEmpty()) {
            if (startingYear.getValue() > 9999 || startingYear.getValue() < 0) {
                Notification.show("Bitte gib einen gültigen Wert für Start Jahr ein!");
                inputIsValid = false;
            }
        }
        if (!endingYear.isEmpty()) {
            if (endingYear.getValue() > 9999 || endingYear.getValue() < 0) {
                Notification.show("Bitte gib einen gültigen Wert für End Jahr ein!");
                inputIsValid = false;
            }
        }
        if (!yearlyDeposit.isEmpty()) {
            if (yearlyDeposit.getValue() > 10000000 || yearlyDeposit.getValue() < 0) {
                Notification.show("Bitte gib einen gültigen Wert für Jährliche Einzahlungen ein!");
                inputIsValid = false;
            }
        }
        if (!yearlyWidthdraw.isEmpty()) {
            if (yearlyWidthdraw.getValue() > 10000000 || yearlyWidthdraw.getValue() < 0) {
                Notification.show("Bitte gib einen gültigen Wert für Jährliche Auszahlungen ein!");
                inputIsValid = false;
            }
        }
        if (!instances.isEmpty()) {
            if (instances.getValue() > 50000 || instances.getValue() < 1) {
                Notification.show("Bitte gib einen gültigen Wert für die Anzahl an Instanzen ein!");
                inputIsValid = false;
            }
        }
        if (!startingCapital.isEmpty()) {
            if (startingCapital.getValue() > 1000000000 || startingCapital.getValue() < 1) {
                Notification.show("Bitte gib einen gültigen Wert für das Startkapital ein!");
                inputIsValid = false;
            }
        }
        if (!inflationRate.isEmpty()) {
            if (inflationRate.getValue() > 100000 || inflationRate.getValue() < 0) {
                Notification.show("Bitte gib einen gültigen Wert für die Inflationsrate ein!");
                inputIsValid = false;
            }
        }
        if (!yieldRate.isEmpty()) {
            if (yieldRate.getValue() > 10000 || yieldRate.getValue() < 0) {
                Notification.show("Bitte gib einen gültigen Wert für die Rendite ein!");
                inputIsValid = false;
            }
        }
        if (!standardDeviation.isEmpty()) {
            if (standardDeviation.getValue() > 1000 || standardDeviation.getValue() < 0) {
                Notification.show("Bitte gib einen gültigen Wert für die Standard Abweichung ein!");
                inputIsValid = false;
            }
        }
        if (!strategy.isEmpty()) {
            if (!strategy.getValue().toString().equals("Hohes Risiko") && !strategy.getValue().toString().equals("Mittleres Risiko") && !strategy.getValue().toString().equals("Niedriges Risiko")){
                Notification.show("Bitte wähle eine gültige Strategie");
                inputIsValid = false;
            }
        }
        if (inputIsValid){
            UI.getCurrent().navigate(DashboardView.class);
            clearForm();
            Notification.show("Daten werden übertragen");

        }
    }


    private void setupInputFields() {
        setupStartingYear();
        setupEndingYear();
        setupYearlyDeposit();
        setupYearlyWidthdraw();
        setupInstances();
        setupStartingCapital();
        setupInflationRate();
        setupYieldRate();
        setupStandardDeviation();
        setupStrategy();
    }

    private void setupStartingYear() {
        startingYear.setMin(999);
        startingYear.setMax(9999);
        startingYear.setValue(2023);
        startingYear.setStepButtonsVisible(true);
        startingYear.setErrorMessage("Bitte gib ein gültiges Jahr ein!");
        startingYear.setRequiredIndicatorVisible(true);
    }

    private void setupEndingYear() {
        endingYear.setMin(999);
        endingYear.setMax(9999);
        endingYear.setValue(2023);
        endingYear.setStepButtonsVisible(true);
        endingYear.setErrorMessage("Bitte gib ein gültiges Jahr ein!");
        endingYear.setRequiredIndicatorVisible(true);
    }

    private void setupYearlyDeposit() {
        yearlyDeposit.setHelperText("");
        yearlyDeposit.setMin(0);
        yearlyDeposit.setMax(10000000);
        yearlyDeposit.setValue(300);
        yearlyDeposit.setStepButtonsVisible(true);
        yearlyDeposit.setErrorMessage("Bitte gib eine gültige Zahl ein!");
        yearlyDeposit.setRequiredIndicatorVisible(true);
    }

    private void setupYearlyWidthdraw() {
        yearlyWidthdraw.setHelperText("");
        yearlyWidthdraw.setMin(0);
        yearlyWidthdraw.setMax(10000000);
        yearlyWidthdraw.setValue(40000);
        yearlyWidthdraw.setStepButtonsVisible(true);
        yearlyWidthdraw.setErrorMessage("Bitte gib eine gültige Zahl ein!");
        yearlyWidthdraw.setRequiredIndicatorVisible(true);
    }

    private void setupInstances() {
        instances.setHelperText("Maximal 50000");
        instances.setMin(1);
        instances.setMax(50000);
        instances.setValue(1000);
        instances.setStepButtonsVisible(true);
        instances.setErrorMessage("Bitte gib eine gültige Zahl ein!");
        instances.setRequiredIndicatorVisible(true);
    }

    private void setupStartingCapital() {
        startingCapital.setHelperText("");
        startingCapital.setMin(1);
        startingCapital.setMax(1000000000);
        startingCapital.setValue(650000);
        startingCapital.setStepButtonsVisible(true);
        startingCapital.setErrorMessage("Bitte gib eine gültige Zahl ein!");
        startingCapital.setRequiredIndicatorVisible(true);
    }

    private void setupInflationRate() {
        inflationRate.setHelperText("");
        inflationRate.setMin(0);
        inflationRate.setMax(100000);
        inflationRate.setValue(4);
        inflationRate.setStepButtonsVisible(true);
        inflationRate.setErrorMessage("Bitte gib eine gültige Zahl ein!");
        inflationRate.setRequiredIndicatorVisible(true);
    }

    private void setupYieldRate() {
        yieldRate.setHelperText("");
        yieldRate.setMin(0);
        yieldRate.setMax(10000);
        yieldRate.setValue(3);
        yieldRate.setStepButtonsVisible(true);
        yieldRate.setErrorMessage("Bitte gib eine gültige Zahl ein!");
        yieldRate.setRequiredIndicatorVisible(true);
    }

    private void setupStandardDeviation() {
        standardDeviation.setHelperText("");
        standardDeviation.setMin(0);
        standardDeviation.setMax(1000);
        standardDeviation.setValue(9);
        standardDeviation.setStepButtonsVisible(true);
        standardDeviation.setErrorMessage("Bitte gib eine gültige Zahl ein!");
        standardDeviation.setRequiredIndicatorVisible(true);
    }

    private void setupStrategy() {
        strategy.setHelperText("");
        strategy.setItems("Hohes Risiko", "Mittleres Risiko", "Niedriges Risiko");
        strategy.setErrorMessage("Bitte gib eine gültige Zahl ein!");
        strategy.setRequiredIndicatorVisible(true);
    }

    private void clearForm() {
        binder.setBean(new SamplePerson());
    }

    private Component createTitle() {
        return new H3("Personal information");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(startingYear, endingYear, yearlyDeposit, yearlyWidthdraw, instances, startingCapital, inflationRate, yieldRate, standardDeviation, strategy);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

    private static class PhoneNumberField extends CustomField<String> {
        private ComboBox<String> countryCode = new ComboBox<>();
        private TextField number = new TextField();

        public PhoneNumberField(String label) {
            setLabel(label);
            countryCode.setWidth("120px");
            countryCode.setPlaceholder("Country");
            countryCode.setAllowedCharPattern("[\\+\\d]");
            countryCode.setItems("+354", "+91", "+62", "+98", "+964", "+353", "+44", "+972", "+39", "+225");
            countryCode.addCustomValueSetListener(e -> countryCode.setValue(e.getDetail()));
            number.setAllowedCharPattern("\\d");
            HorizontalLayout layout = new HorizontalLayout(countryCode, number);
            layout.setFlexGrow(1.0, number);
            add(layout);
        }

        @Override
        protected String generateModelValue() {
            if (countryCode.getValue() != null && number.getValue() != null) {
                String s = countryCode.getValue() + " " + number.getValue();
                return s;
            }
            return "";
        }

        @Override
        protected void setPresentationValue(String phoneNumber) {
            String[] parts = phoneNumber != null ? phoneNumber.split(" ", 2) : new String[0];
            if (parts.length == 1) {
                countryCode.clear();
                number.setValue(parts[0]);
            } else if (parts.length == 2) {
                countryCode.setValue(parts[0]);
                number.setValue(parts[1]);
            } else {
                countryCode.clear();
                number.clear();
            }
        }
    }

}
