import{m as n}from"./index-gxZJ1D_R.js";const e="/api/student/coupon",s={async getCouponlist(){try{const{data:o}=await n.get(`${e}/list`);return o}catch(o){throw console.error("Failed to fetch coupon list:",o),o}},async getCouponById(o){try{const{data:t}=await n.get(`${e}/list/${o}`);return t}catch(t){throw console.error(`Failed to fetch coupon with id ${o}:`,t),t}},async buyCoupon(o){try{return console.log("쿠폰 구매 정보 ",o),await n.post(`${e}/buy`,o.value)}catch(t){throw console.error("Failed to buy coupon",t),t}},async getStudentCoupons(o){const{data:t}=await n.get(`${e}/mycp`);return console.log("Student coupons GET",t),t},async usageCoupon(o){return console.log(o),await n.post(`${e}/use`,o)}};export{s as a};
