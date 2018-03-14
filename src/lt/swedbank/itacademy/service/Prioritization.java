package lt.swedbank.itacademy.service;

import lt.swedbank.itacademy.domain.Loan;
import lt.swedbank.itacademy.domain.LoanRiskType;

import java.util.Comparator;

public class Prioritization {//implements Comparator<Loan> {


//    @Override
//    public int compare(Loan o1, Loan o2) {
//        if (o1.getRiskType().compareTo(o2.getRiskType()) > 0) {
//            return 1;
//        }
//        if (o1.getRiskType().compareTo(o2.getRiskType()) < 0) {
//            return -1;
//        }
//        if (o1.calculateTotalLoanCost().compareTo(o2.calculateTotalLoanCost()) < 0) {
//            return 1;
//        }
//        if (o1.calculateTotalLoanCost().compareTo(o2.calculateTotalLoanCost()) > 0) {
//            return -1;
//        }
//        if (o1.getCreationDate().compareTo(o2.getCreationDate()) > 0) {
//            return 1;
//        }
//        if (o1.getCreationDate().compareTo(o2.getCreationDate()) < 0) {
//            return -1;
//        } else return 0;
//    }
}
