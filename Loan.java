//  John Gumm
//  CIS 279

public class Loan {
  private double salaryAndWages;
  private double interestIncome;
  private double investmentIncome;
  private double otherIncome;
  private double annualInterestRate;
  private int termInYears;
  private double loanAmount;

  // No-arg constructor
  public Loan(){

  }

  // Constructor with args
  public Loan(double salaryAndWages, double interestIncome, double investmentIncome, double otherIncome, double annualInterestRate, int termInYears, double loanAmount) {
    this.salaryAndWages = salaryAndWages;
    this.interestIncome = interestIncome;
    this.investmentIncome = investmentIncome;
    this.otherIncome = otherIncome;
    this.annualInterestRate = annualInterestRate;
    this.termInYears = termInYears;
    this.loanAmount = loanAmount;
  }

  // Calculate total income
  public double calcTotalIncome() {
    double totalIncome = 0;

    totalIncome = salaryAndWages + interestIncome + investmentIncome + otherIncome;

    return totalIncome;
  }

  // Calculate total payments over life of loan
  public int calcTotalPaymentsOverLifeOfLoan(){
    int totalPayments = 0;

    totalPayments = termInYears * 12;

    return totalPayments;
  }

  // Calculate monthly payment
  public double calculateMonthlyPayment(){
    
    double monthlyInterestRate = (annualInterestRate/12) /100;
    double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
        (1 / Math.pow(1 + monthlyInterestRate, termInYears * 12)));

    return monthlyPayment;
  }

  // Calculate loan eligibility
  public boolean isEligible(double percentage) {
    boolean eligible = true;

    if (this.calculateMonthlyPayment() > (this.calcTotalIncome() * percentage)) {
      eligible = false;
    }

    return eligible;
  }

  // Getters and setters
  public double getSalaryAndWages() {
    return this.salaryAndWages;
  }

  public void setSalaryAndWages(double salaryAndWages) {
    this.salaryAndWages = salaryAndWages;
  }

  public double getInterestIncome() {
    return this.interestIncome;
  }

  public void setInterestIncome(double interestIncome) {
    this.interestIncome = interestIncome;
  }

  public double getInvestmentIncome() {
    return this.investmentIncome;
  }

  public void setInvestmentIncome(double investmentIncome) {
    this.investmentIncome = investmentIncome;
  }

  public double getOtherIncome() {
    return this.otherIncome;
  }

  public void setOtherIncome(double otherIncome) {
    this.otherIncome = otherIncome;
  }

  public double getAnnualInterestRate() {
    return this.annualInterestRate;
  }

  public void setAnnualInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate;
  }

  public int getTermInYears() {
    return this.termInYears;
  }

  public void setTermInYears(int termInYears) {
    this.termInYears = termInYears;
  }

  public double getLoanAmount() {
    return this.loanAmount;
  }

  public void setLoanAmount(double loanAmount) {
    this.loanAmount = loanAmount;
  }
  
    
  }