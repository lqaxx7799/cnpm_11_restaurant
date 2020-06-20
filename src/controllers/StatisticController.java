/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import views.StatisticView;

/**
 *
 * @author Admin
 */
public class StatisticController {
    private StatisticView statisticView;
    
    public StatisticController(){
        statisticView = new StatisticView();
        
        statisticView.getTabStatistic().add("Doanh thu", new RevenueStatisticController().initController());
    }
    
    public StatisticView initController(){
        return statisticView;
    }
}
