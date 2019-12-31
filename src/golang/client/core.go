package client

import (
	"context"
	"time"

	"github.com/hexagram30/dice/src/golang/api"
	log "github.com/sirupsen/logrus"

	"google.golang.org/grpc"
)

const (
	shortTimeout = (20 * time.Millisecond) + 1*time.Minute
)

// Client ...
type Client struct {
	ConnectionString string
	Conn             *grpc.ClientConn
	Client           api.ServiceAPIClient
}

// New ...
func New(connStr string) *Client {
	return &Client{ConnectionString: connStr}
}

// Close the gRPC connection
func (c *Client) Close() {
	c.Conn.Close()
}

// SetupConnection ...
func (c *Client) SetupConnection() {
	conn, err := grpc.Dial(c.ConnectionString, grpc.WithInsecure())
	if err != nil {
		log.Fatalf("did not connect to gRPC server: %v", err)
	}
	c.Conn = conn
	c.Client = api.NewServiceAPIClient(conn)
}

/////////////////////////////////////////////////////////////////////////////
///   Client Implementation for the gRPC Server API    //////////////////////
/////////////////////////////////////////////////////////////////////////////

// Ping ...
func (c *Client) Ping() string {

	ctx, cancel := context.WithTimeout(context.Background(), shortTimeout)
	defer cancel()

	r, err := c.Client.Ping(ctx, &api.PingRequest{})
	if err != nil {
		log.Fatalf("Could not get ping reply: %v", err)
	}

	return r.GetData()
}

// Version ...
func (c *Client) Version() *api.VersionReply {

	ctx, cancel := context.WithTimeout(context.Background(), shortTimeout)
	defer cancel()

	r, err := c.Client.Version(ctx, &api.VersionRequest{})
	if err != nil {
		log.Fatalf("Could not get version: %v", err)
	}
	log.Debugf("Version data: %v", r)

	return r
}
