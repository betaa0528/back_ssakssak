import{R as a}from"./index-DvTNLHIP.js";import{a as e}from"./studentStockApi-kF3M_Z2u.js";const r=a("stock",{state:()=>({myStock:{stdId:"",totalQuantity:"",totalInvestment:"",averagePrice:"",currentValue:"",profitLoss:"",profitRate:"",seed:""},chartData:[],newsList:[]}),actions:{async fetchMyStock(){try{const t=await e.getMyStock();this.myStock=t}catch(t){console.error("Failed to fetch stock:",t)}},updateMyStock(t){this.myStock=t},async fetchChartData(){try{const t=await e.getChartData();this.chartData=t}catch(t){console.error("Failed to fetch chart data:",t)}},async fetchNewsList(){try{const t=await e.getNewsList();this.newsList=t}catch(t){console.error("Failed to fetch newsList",t)}}},persist:!0});export{r as u};
