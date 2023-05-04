<template>
  <div class="header">
    <el-form :inline="true" :model="form" class="demo-form-inline">
      <span style="margin-right: 150px">租客未缴列表</span>
      <el-form-item label="租客姓名:">
        <el-input v-model="form.search" placeholder="姓名" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
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
      <el-table-column align="center" prop="price" label="应缴租金" />
      <el-table-column align="center" prop="date" label="租金应缴日期" />
      <el-table-column align="center" prop="name" label="租赁人姓名" />
      <el-table-column align="center" prop="status" label="状态" />
    </el-table>
  </div>
</template>
  
<script setup>
import { reactive, ref, onMounted } from "vue";
import { get, post } from "@/api/request";
const form = reactive({
  search: "",
});
// 刷新
const shuaxin = () => {
  form.search = "";
  getData();
};
// 查询
const onSubmit = () => {
  console.log(form.search);
  console.log("点击查询");
  getData();
};
const tableData = ref([]);

// 表格数据
const getData = () => {
  get("/api/topaidlist", {
    search: form.search,
  }).then((resp) => {
    console.log(resp);
    tableData.value = resp.data;
  });
};

// 初始化表格数据
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
  