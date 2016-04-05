# wwsko-techdays-diy

Steps to deploy boot example on Mesos:

1) Deploy DOCS to AWS [https://mesosphere.com/amazon/setup/ https://mesosphere.com/amazon/setup/]

2) Point DCOS CLI to your Mesos URL (from output of Cloudformation template).  Then deploy cassandra service.
  - dcos config set core.dcos_url $URL
  - dcos package install cassandra

3) Deploy sample apps in boot example direction
  - Docker image to update Cassandra: dcos marathon app add cassandra-init.json
  - Main java app: dcos marathon app add marathon-app.json
  - Public NGinx Proxy: dcos marathon app add proxy/marathon-web-proxy.json
  - Access Application:
    * curl -d '{"content":"init","handle":"azwickey"}' -H 'Content-Type: application/json' http://$MESOS_URL/api/models
    * curl /test
    * curl /api/models
  
