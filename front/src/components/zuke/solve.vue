<template>
  <div class="header">
    <el-form :inline="true" class="demo-form-inline">
      <span style="margin-right: 150px">已处理报障</span>
    </el-form>
    <br />
    <el-button @click="shuaxin()">
      <el-icon size="30"><Refresh /></el-icon>
    </el-button>
  </div>
  <div class="wrapper">
    <el-table
      :data="tableData"
      border
      style="width: 100%"
      empty-text="暂无数据"
      @selection-change="handleSelectionChange"
    >
      <el-table-column
        align="center"
        prop="house_id"
        label="房屋ID"
        width="180"
      />
      <el-table-column align="center" prop="address" label="地址" />
      <el-table-column align="center" prop="date" label="报障日期" />
      <el-table-column align="center" prop="name" label="租赁人" />
      <el-table-column align="center" prop="detail" label="报障内容" />
      <el-table-column align="center" prop="status" label="状态" />
    </el-table>
  </div>
</template>
      
<script setup>
import { reactive, ref, onMounted } from "vue";
import { get, post } from "@/api/request";
import { ElMessage } from "element-plus";

// 刷新
const shuaxin = () => {
  getData();
};
let tableData = ref([]);
// 表格数据
const getData = () => {
  let user = window.sessionStorage.getItem("token-U");
  let username = JSON.parse(user).username;
  get("/api/solvelistU", {
    name: username,
  }).then((resp) => {
    console.log(resp);
    tableData.value = resp.data;
  });
};
// 获取表格数据
onMounted(() => {
  getData();
});
</script>

<style scoped>
.header {
  border: 1px solid #eee;
  padding: 10px;
  border-radius: 6px;
}
.el-form-item {
  margin-bottom: 0;
}
</style>
      