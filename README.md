# MongoDB Spring Boot 示範專案 ⚡

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## 專案介紹

這是一個展示 Spring Boot 與 MongoDB 整合的示範專案，主要用於教學和實務參考。

- 實現完整的 MongoDB CRUD 操作
- 展示自定義類型轉換器的使用
- 示範 Spring Data MongoDB 的最佳實踐
- 適合後端開發者和架構師學習參考

> 💡 **為什麼選擇此專案？**
> - 完整展示 MongoDB 與 Spring Boot 的整合方式
> - 提供實用的自定義轉換器範例

### 🎯 專案特色

- 完整的 MongoDB CRUD 操作示範
- 自定義 Money 類型轉換器
- Docker 容器化部署支援
- 詳細的註解和文件說明

## 技術棧

### 核心框架
- **Spring Boot 3.4.5** - 快速開發 Java 應用程式
- **Spring Data MongoDB** - MongoDB 資料存取框架
- **MongoDB** - NoSQL 資料庫系統

### 開發工具與輔助
- **Docker** - 容器化部署工具
- **Maven** - 專案建構工具
- **Lombok** - Java 程式碼簡化工具
- **Joda Money** - 貨幣處理函式庫

## 專案結構

```
mongodb-demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── tw/fengqing/spring/data/mongodemo/
│   │   │       ├── MongoDemoApplication.java
│   │   │       ├── model/
│   │   │       ├── converter/
│   │   │       └── config/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## 快速開始

### 前置需求
- Java 17 或以上版本
- Maven 3.6+
- Docker 環境

### 安裝與執行

1. **克隆專案：**
```bash
git clone https://github.com/SpringMicroservicesCourse/mongo-demo.git
```

2. **啟動 MongoDB：**
```bash
docker run -d --name mongo -p 27017:27017 mongo:latest
```

3. **建置專案：**
```bash
mvn clean install
```

4. **執行應用程式：**
```bash
mvn spring-boot:run
```

## 進階說明

### 環境變數
```properties
# MongoDB 連線設定
MONGO_HOST=localhost
MONGO_PORT=27017
MONGO_DB=springbucks
MONGO_USER=springbucks
MONGO_PASS=springbucks
```

### 設定檔說明
```properties
# application.properties
spring.data.mongodb.uri=mongodb://${MONGO_USER}:${MONGO_PASS}@${MONGO_HOST}:${MONGO_PORT}/${MONGO_DB}
logging.level.org.springframework.data.mongodb.core=DEBUG
```

## 參考資源

- [Spring Data MongoDB 官方文件](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/)
- [MongoDB 官方文件](https://docs.mongodb.com/)
- [Docker 官方文件](https://docs.docker.com/)

## 注意事項與最佳實踐

### ⚠️ 重要提醒

| 項目 | 說明 | 建議做法 |
|------|------|----------|
| 資料庫連線 | MongoDB 認證設定 | 使用環境變數管理連線資訊 |
| 效能優化 | 索引使用 | 根據查詢需求建立適當索引 |
| 類型轉換 | 自定義轉換器 | 實作對應的轉換邏輯 |

### 🔒 最佳實踐指南

- 善用 MongoDB 的索引功能
- 實作適當的錯誤處理機制
- 注意資料庫連線池的管理

## 授權說明

本專案採用 MIT 授權條款，詳見 LICENSE 檔案。

## 關於我們

我們是一個專注於 Java 企業級應用開發的團隊，致力於提供高品質的技術解決方案。

## 聯繫我們

- **部落格**：[風清雲談](https://blog.fengqing.tw/)
- **電子郵件**：[fengqing.tw@gmail.com](mailto:fengqing.tw@gmail.com)

---

**📅 最後更新：2025-06-27**  
**👨‍💻 維護者：風清雲談團隊**