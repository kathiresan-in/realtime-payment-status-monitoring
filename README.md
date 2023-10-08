docker run kathiresan2in/realtime-payment-status-monitoring:latest

docker run -it -p 28000:27017 --name mongoContainer mongo:latest mongo

1). Connect mongosh cli to atlas mongodb.
    Command: #/usr/bin/mongosh "mongodb+srv://connectingdots.vqwab5h.mongodb.net/" --apiVersion 1 --username kathiresan

2). Some basic mongosh commands.
    > show dbs
    > use banking
    > db.payments.find({nodeReference: "1e6e9e91-4af4-404c-bb23-a245be77dea4"})
    > db.payments.aggregate([{$graphLookup: {from: 'payments',startWith: '$parentNodeReference',connectFromField: 'parentNodeReference',connectToField: 'nodeReference',maxDepth: 3,depthField: 'nodeHierarchy',as: 'paymentTree'}}])