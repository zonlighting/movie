<template>
  <v-main>
    <v-data-table
      :headers="headers"
      :items="desserts"
      sort-by="calories"
      class="elevation-1"
      @update:items-per-page="perPageClick"
      @update:page="pageClick"
      :items-per-page="pageSize"
      @click:row="clickRow"
      v-model="selected"
      :single-select="false"
      item-key="id"
      show-select
    >
      <template v-slot:[`item.image`]="{ item }">
        <v-img
          lazy-src="https://picsum.photos/id/11/10/6"
          max-width="240"
          :src="item.image"
        ></v-img>
      </template>
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>Films</v-toolbar-title>

          <v-divider class="mx-4" inset vertical></v-divider>
          <v-btn color="primary" dark class="mb-2"> Delete Film Choose</v-btn>
          <v-spacer></v-spacer>
          <v-btn color="primary" dark class="mb-2"> New Film </v-btn>
        </v-toolbar>
        <v-toolbar flat>
          <v-row>
            <v-col>
              <v-text-field
                v-model="searchName"
                append-icon="mdi-magnify"
                label="Search Name"
              ></v-text-field>
            </v-col>
            <v-col>
              <v-select
                v-model="searchCategory"
                :items="categories"
                item-value="id"
                item-text="name"
                label="Choose Category"
              ></v-select>
            </v-col>
            <v-col>
              <v-select
                v-model="searchYear"
                :items="listYear"
                label="Choose Year"
              ></v-select>
            </v-col>
            <v-col>
              <v-select
                v-model="searchArea"
                :items="listArea"
                label="Choose Area"
              ></v-select>
            </v-col>
            <v-col>
              <v-select
                v-model="searchStatus"
                :items="listStatus"
                item-value="id"
                item-text="text"
                label="Choose Status"
              ></v-select>
            </v-col>
          </v-row>
        </v-toolbar>
      </template>
      <template v-slot:[`item.actions`]="{ item }">
        <v-btn>Delete</v-btn>

        {{ item.id }}
      </template>
      <template v-slot:[`footer.page-text`]="props">
        {{ props.pageStart }} in {{ totalPage }}
      </template>
    </v-data-table>
  </v-main>
</template>
<script>
export default {
  data() {
    return {
      searchName: "",
      searchArea:"",
      searchStatus:"",
      searchYear: "",
      searchCategory: "",
      pageSize: 5,
      page: 1,
      totalPage: 0,
      selected: [],
      categories: [
        { id: "0", name: "No select" },
        { id: "1", name: "horror" },
        { id: "2", name: "funny" },
        { id: "3", name: "romantic" },
        { id: "4", name: "anime" },
        { id: "5", name: "fiction" },
        { id: "6", name: "school" },
      ],
      headers: [
        {
          text: "Name",
          align: "start",
          sortable: false,
          value: "name",
          witdh: "200px",
        },
        { text: "Wallpaper", value: "image", sortable: false, width: "250px" },
        { text: "Infomation", value: "info" },
        { text: "Time", value: "time", width: "150px" },
        { text: "Category", value: "category", width: "200px" },
        { text: "Area", value: "area", width: "200px" },
        { text: "Director", value: "director", width: "200px" },
        { text: "Status", value: "status", width: "100px" },
        { text: "Episode", value: "episode", width: "100px" },
      ],
      desserts: [
        {
          id: "1",
          name: "Đêm trong căn nhà ma",
          info: "Phim ma kinh dị có yếu tố mạnh ,cẩn thận khi xem",
          image:
            "https://i0.wp.com/designer.com.vn/wp-content/uploads/2017/07/poster-phim-kinh-di.jpg",
          time: "2015-12-20",
          area: "China",
          director: "zon",
          category: "horror",
          status: "3",
          episode: "13",
        },
        {
          id: "2",
          name: "Đêm trong căn nhà ma",
          info: "Phim ma kinh dị có yếu tố mạnh ,cẩn thận khi xem",
          image:
            "https://i0.wp.com/designer.com.vn/wp-content/uploads/2017/07/poster-phim-kinh-di.jpg",
          time: "2015-12-20",
          area: "China",
          director: "zon",
          category: "horror",
          status: "3",
          episode: "13",
        },
        {
          id: "3",
          name: "Đêm trong căn nhà ma",
          info: "Phim ma kinh dị có yếu tố mạnh ,cẩn thận khi xem",
          image:
            "https://i0.wp.com/designer.com.vn/wp-content/uploads/2017/07/poster-phim-kinh-di.jpg",
          time: "2015-12-20",
          area: "China",
          director: "zon",
          category: "horror",
          status: "3",
          episode: "13",
        },
        {
          id: "4",
          name: "Đêm trong căn nhà ma",
          info: "Phim ma kinh dị có yếu tố mạnh ,cẩn thận khi xem",
          image:
            "https://i0.wp.com/designer.com.vn/wp-content/uploads/2017/07/poster-phim-kinh-di.jpg",
          time: "2015-12-20",
          area: "China",
          director: "zon",
          category: "horror",
          status: "3",
          episode: "13",
        },
        {
          id: "5",
          name: "Đêm trong căn nhà ma",
          info: "Phim ma kinh dị có yếu tố mạnh ,cẩn thận khi xem",
          image:
            "https://i0.wp.com/designer.com.vn/wp-content/uploads/2017/07/poster-phim-kinh-di.jpg",
          time: "2015-12-20",
          area: "China",
          director: "zon",
          category: "horror",
          status: "3",
          episode: "13",
        },
        {
          id: "6",
          name: "Đêm trong căn nhà ma",
          info: "Phim ma kinh dị có yếu tố mạnh ,cẩn thận khi xem",
          image:
            "https://i0.wp.com/designer.com.vn/wp-content/uploads/2017/07/poster-phim-kinh-di.jpg",
          time: "2015-12-20",
          area: "China",
          director: "zon",
          category: "horror",
          status: "3",
          episode: "13",
        },
        {
          id: "7",
          name: "Đêm trong căn nhà ma",
          info: "Phim ma kinh dị có yếu tố mạnh ,cẩn thận khi xem",
          image:
            "https://i0.wp.com/designer.com.vn/wp-content/uploads/2017/07/poster-phim-kinh-di.jpg",
          time: "2015-12-20",
          area: "China",
          director: "zon",
          category: "horror",
          status: "3",
          episode: "13",
        },
        {
          id: "8",
          name: "Đêm trong căn nhà ma",
          info: "Phim ma kinh dị có yếu tố mạnh ,cẩn thận khi xem",
          image:
            "https://i0.wp.com/designer.com.vn/wp-content/uploads/2017/07/poster-phim-kinh-di.jpg",
          time: "2015-12-20",
          area: "China",
          director: "zon",
          category: "horror",
          status: "3",
          episode: "13",
        },
        {
          id: "9",
          name: "Đêm trong căn nhà ma",
          info: "Phim ma kinh dị có yếu tố mạnh ,cẩn thận khi xem",
          image:
            "https://i0.wp.com/designer.com.vn/wp-content/uploads/2017/07/poster-phim-kinh-di.jpg",
          time: "2015-12-20",
          area: "China",
          director: "zon",
          category: "horror",
          status: "3",
          episode: "13",
        },
        {
          id: "10",
          name: "Đêm trong căn nhà ma",
          info: "Phim ma kinh dị có yếu tố mạnh ,cẩn thận khi xem",
          image:
            "https://i0.wp.com/designer.com.vn/wp-content/uploads/2017/07/poster-phim-kinh-di.jpg",
          time: "2015-12-20",
          area: "China",
          director: "zon",
          category: "horror",
          status: "3",
          episode: "13",
        },
        {
          id: "11",
          name: "Đêm trong căn nhà ma",
          info: "Phim ma kinh dị có yếu tố mạnh ,cẩn thận khi xem",
          image:
            "https://i0.wp.com/designer.com.vn/wp-content/uploads/2017/07/poster-phim-kinh-di.jpg",
          time: "2015-12-20",
          area: "China",
          director: "zon",
          category: "horror",
          episode: "13",
        },
        {
          id: "12",
          name: "Đêm trong căn nhà ma",
          info: "Phim ma kinh dị có yếu tố mạnh ,cẩn thận khi xem",
          image:
            "https://i0.wp.com/designer.com.vn/wp-content/uploads/2017/07/poster-phim-kinh-di.jpg",
          time: "2015-12-20",
          area: "China",
          director: "zon",
          category: "horror",
          status: "3",
          episode: "13",
        },
        {
          id: "13",
          name: "Đêm trong căn nhà ma",
          info: "Phim ma kinh dị có yếu tố mạnh ,cẩn thận khi xem",
          image:
            "https://i0.wp.com/designer.com.vn/wp-content/uploads/2017/07/poster-phim-kinh-di.jpg",
          time: "2015-12-20",
          area: "China",
          director: "zon",
          category: "horror",
          status: "3",
          episode: "13",
        },
        {
          id: "14",
          name: "Đêm trong căn nhà ma",
          info: "Phim ma kinh dị có yếu tố mạnh ,cẩn thận khi xem",
          image:
            "https://i0.wp.com/designer.com.vn/wp-content/uploads/2017/07/poster-phim-kinh-di.jpg",
          time: "2015-12-20",
          area: "China",
          director: "zon",
          category: "horror",
          status: "3",
          episode: "13",
        },
      ],
      listYear: ["No Select"],
      listArea: ["No Select", "China", "Viet Nam"],
      listStatus:[
          {id:"3",text:"No select"},
          {id:"0",text:"Upcomming"},
          {id:"1",text:"Doing"},
          {id:"2",text:"End"},
      ]
    };
  },
  created() {
    this.getListYear();
  },
  methods: {
    getListYear() {
      var a = new Date().getFullYear();
      for (var i = 1990; i <= a; i++) {
        this.listYear.push(i);
      }
    },
    perPageClick(event) {
      if (event != -1) {
        this.pageSize = event;
      }
    },
    pageClick(event) {
      this.page = event;
    },
    clickRow() {
      
    },
  },
};
</script>