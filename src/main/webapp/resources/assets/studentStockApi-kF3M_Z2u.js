import{m as t}from"./index-DvTNLHIP.js";const r="/api/student/stock",o={async getNewsList(){const{data:e}=await t.get(`${r}/news`);return e},async getChartData(){const{data:e}=await t.get(`${r}/data`);return console.log("getChartData",e),e},async updateNewsStatus(e){try{const s=await t.put(`${r}/news/${e}/status`,{status:"n"});return console.log("News status updated:",s.data),s.data}catch(s){throw console.error("Error updating news status:",s),s}},async getMyStock(){const{data:e}=await t.get(`${r}/my-stock`);return e},async buyStock(e){try{return await t.post(`${r}/buy`,e)}catch(s){s.response&&s.response.data?errorMsg=s.response.data:errorMsg="알 수 없는 오류가 발생했습니다!"}},async sellStock(e){console.log(e);try{return await t.post(`${r}/sell`,e)}catch(s){s.response&&s.response.data?errorMsg.value=s.response.data:errorMsg.value="알 수 없는 오류가 발생했습니다!"}},async getStudentProfile(){try{return await t.get(`/student/profile/${stdId}`)}catch(e){e.response&&e.response.data?errorMsg.value=e.response.data:errorMsg.value="알 수 없는 오류가 발생했습니다!"}}};export{o as a};
